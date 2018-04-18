package com.zby.dao;

import com.zby.po.UserPo;

public interface UseroDao {
	
	int deleteByPrimaryKey(Integer id);

	int insert(UserPo userPo);

	int insertSelective(UserPo userPo);

	UserPo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserPo userPo);

	int updateByPrimaryKey(UserPo userPo);
}