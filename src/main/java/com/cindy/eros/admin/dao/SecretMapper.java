package com.cindy.eros.admin.dao;

import com.cindy.eros.admin.model.Secret;

public interface SecretMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secret
     *
     * @mbggenerated Thu Aug 09 18:08:09 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secret
     *
     * @mbggenerated Thu Aug 09 18:08:09 CST 2018
     */
    int insert(Secret record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secret
     *
     * @mbggenerated Thu Aug 09 18:08:09 CST 2018
     */
    int insertSelective(Secret record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secret
     *
     * @mbggenerated Thu Aug 09 18:08:09 CST 2018
     */
    Secret selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secret
     *
     * @mbggenerated Thu Aug 09 18:08:09 CST 2018
     */
    int updateByPrimaryKeySelective(Secret record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secret
     *
     * @mbggenerated Thu Aug 09 18:08:09 CST 2018
     */
    int updateByPrimaryKey(Secret record);
}