package com.asiainfo.test.mapper;

import com.asiainfo.test.domain.TyTestUser;

import java.util.List;

public interface TyTestMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TyTestUser record);

    int insertSelective(TyTestUser record);

    TyTestUser selectByPrimaryKey(Integer id);

    /**
     * 查询全部
     * @return
     */
    List<TyTestUser> queryAll();

    int deleteUserByIds(Integer ids);

    int updateByPrimaryKeySelective(TyTestUser record);

    int updateByPrimaryKey(TyTestUser record);
}