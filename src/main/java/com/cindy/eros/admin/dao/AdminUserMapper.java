package com.cindy.eros.admin.dao;

import com.cindy.eros.admin.model.AdminUser;
import org.springframework.stereotype.Component;

@Component
public interface AdminUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    int insert(AdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    int insertSelective(AdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    AdminUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    int updateByPrimaryKeySelective(AdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    int updateByPrimaryKey(AdminUser record);

    /**
     *
     * @param username
     * @return
     */
    AdminUser selectByUsername(String username);
}