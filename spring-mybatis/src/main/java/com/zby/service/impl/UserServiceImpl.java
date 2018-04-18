package com.zby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zby.dao.UseroDao;
import com.zby.po.UserPo;
import com.zby.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UseroDao userDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserPo userPo) {
		return userDao.insert(userPo);
	}

	@Override
	public int insertSelective(UserPo userPo) {
		return userDao.insertSelective(userPo);
	}

	@Override
	public UserPo selectByPrimaryKey(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserPo userPo) {
		return userDao.updateByPrimaryKey(userPo);
	}

	@Override
	public int updateByPrimaryKey(UserPo userPo) {
		return userDao.updateByPrimaryKey(userPo);
	}

}
