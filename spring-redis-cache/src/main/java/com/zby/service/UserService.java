package com.zby.service;

import com.zby.po.User;

public interface UserService {
	User queryUser(String name);
	User updateDB(User user);
	void reload();
}
