/*
*
* TbSystemLogInfoMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-08-12
*/
package com.auth.mapper;

import com.pojo.entity.TbSystemLogInfo;

public interface TbSystemLogInfoMapper {
    /**
     *
     * @mbg.generated 2020-08-12
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-08-12
     */
    int insert(TbSystemLogInfo record);

    /**
     *
     * @mbg.generated 2020-08-12
     */
    int insertSelective(TbSystemLogInfo record);

    /**
     *
     * @mbg.generated 2020-08-12
     */
    TbSystemLogInfo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-08-12
     */
    int updateByPrimaryKeySelective(TbSystemLogInfo record);

    /**
     *
     * @mbg.generated 2020-08-12
     */
    int updateByPrimaryKey(TbSystemLogInfo record);
}