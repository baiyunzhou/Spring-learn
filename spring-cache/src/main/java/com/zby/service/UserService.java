package com.zby.service;

import com.zby.po.User;

public interface UserService {
	User queryUser(Integer id);
	User updateDB(User user);
	void reload();
}
