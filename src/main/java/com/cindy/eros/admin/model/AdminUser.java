package com.cindy.eros.admin.model;

import java.util.Date;

public class AdminUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.id
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.username
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.password
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.is_deleted
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private Boolean isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.is_blocked
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private Boolean isBlocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.create_time
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.update_time
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.id
     *
     * @return the value of admin_user.id
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.id
     *
     * @param id the value for admin_user.id
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.username
     *
     * @return the value of admin_user.username
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.username
     *
     * @param username the value for admin_user.username
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.password
     *
     * @return the value of admin_user.password
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.password
     *
     * @param password the value for admin_user.password
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.is_deleted
     *
     * @return the value of admin_user.is_deleted
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.is_deleted
     *
     * @param isDeleted the value for admin_user.is_deleted
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.is_blocked
     *
     * @return the value of admin_user.is_blocked
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public Boolean getIsBlocked() {
        return isBlocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.is_blocked
     *
     * @param isBlocked the value for admin_user.is_blocked
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.create_time
     *
     * @return the value of admin_user.create_time
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.create_time
     *
     * @param createTime the value for admin_user.create_time
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.update_time
     *
     * @return the value of admin_user.update_time
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.update_time
     *
     * @param updateTime the value for admin_user.update_time
     *
     * @mbggenerated Mon Jul 30 17:48:58 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}