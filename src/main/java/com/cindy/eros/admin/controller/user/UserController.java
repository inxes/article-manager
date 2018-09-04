package com.cindy.eros.admin.controller.user;

import com.auth0.jwt.interfaces.Claim;
import com.cindy.eros.admin.model.AdminUser;
import com.cindy.eros.admin.model.BaseResponse;
import com.cindy.eros.admin.mq.impl.MqProducerService;
import com.cindy.eros.admin.service.impl.AdminUserServiceImp;
import com.cindy.eros.util.JwtUtil;
import com.cindy.eros.util.MailUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {

    @PostMapping("/logon")
    @CrossOrigin(origins = "http://localhost:8080")
    public BaseResponse logon(@RequestParam("username") String username,
                              @RequestParam("pwd") String pwd,
                              @RequestParam("email") String email,
                              AdminUserServiceImp adminUserServiceImp,
                              StringRedisTemplate redis){
        if (adminUserServiceImp.selectByUsername(username) != null){
            return BaseResponse.failure(120,"注册失败！该账号已被使用");
        }
        AdminUser user = new AdminUser();
        Date date = new Date();
        user.setUsername(username);
        user.setPassword(BCrypt.hashpw(pwd,BCrypt.gensalt()));
        user.setIsBlocked(false);
        user.setIsDeleted(false);
        user.setCreateTime(date);
        System.out.println("redis:"+user.getId().toString());
        //存入redis
        redis.opsForValue().set(user.getId().toString(),"true");

        MailUtil mailUtil = new MailUtil();
        mailUtil.sendMile(email,"【EROS】验证邮件","以下为您的验证码，验证码24小时内有效：");

        //生成token
        try{
            Integer id = adminUserServiceImp.saveUserReturnId(user);
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.createJwt(id);
            return BaseResponse.success(token);
        }catch (Exception e){
            return BaseResponse.failure(121,"注册失败！"+e.getMessage());
        }

    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    //一个浏览器对应一个唯一sessionid，浏览器第一次请求都会创建session，关闭浏览器，重启服务器，服务端控制session都能使session失效
    public BaseResponse login(@RequestParam(value = "username",required = false,defaultValue = "") String username,
                              @RequestParam(value = "pwd",required = false,defaultValue = "") String pwd,
                              @RequestHeader(value = "Authorization",required = false,defaultValue = "") String auth,
                              HttpSession session,
                              AdminUserServiceImp adminUserServiceImp,
                              MqProducerService mqProducerService,
                              StringRedisTemplate redis){
        JwtUtil jwtUtil = new JwtUtil();

        if(!username.isEmpty() && !pwd.isEmpty()){
            //數據庫校驗
            AdminUser user = adminUserServiceImp.selectByUsername(username);
            String password = user.getPassword();
            Boolean checkLogin = BCrypt.checkpw(pwd,password);

            //校验通过，发放token
            if(checkLogin){
                //存入session
                session.setAttribute("uid",user.getId());
                session.setAttribute("session_id",session.getId());

                Destination destination = new ActiveMQQueue("mytest.queue");
                mqProducerService.sendMessage(destination,user.getId().toString());
                System.out.println("session_id:"+session.getId());
                System.out.println("uid"+session.getAttribute("uid"));
                Integer id = user.getId();
                try{
                    String token = jwtUtil.createJwt(id);
                    session.setAttribute(username,session.getId());
                    redis.opsForValue().set(id.toString(),"true");

                    return BaseResponse.success(token);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    return BaseResponse.failure(123,"登陆失败！");
                }

            }else{
                return BaseResponse.failure(123,"登陆失败！");
            }

        }else if(!auth.isEmpty()){
            Map<String,Claim> map = jwtUtil.verifyJwt(auth);
            //jwt校驗
            if(username.isEmpty() && pwd.isEmpty() && !map.isEmpty()){
                //校验通过，存储session
                session.setAttribute("uid",map.get("userid").asInt());
                session.setAttribute("session_id",session.getId());

                System.out.println("session_id:"+session.getId());
                System.out.println("uid"+session.getAttribute("uid"));
                return BaseResponse.success(auth);
            }else if(!map.isEmpty()){
                return BaseResponse.failure(123,"登陆过期，请重新登陆!");
            }

        }
        return BaseResponse.failure(123,"请填写用户名和密码!");




    }

    @PostMapping("/checkUsername")
    @CrossOrigin(origins = "http://localhost:8080")
    public BaseResponse checkUsername(@RequestParam("username") String username,
                                      AdminUserServiceImp adminUserServiceImp){
        AdminUser user = adminUserServiceImp.selectByUsername(username);
        if(user == null){
            return BaseResponse.success(false);
        }else{
            return BaseResponse.success(true);
        }

    }

    @PostMapping("/logout")
    @CrossOrigin(origins = "http://localhost:8080")
    public BaseResponse logout(@RequestParam("id") Integer id){
        return BaseResponse.success(true);
    }
}