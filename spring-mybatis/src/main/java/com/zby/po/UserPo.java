package com.zby.po;

import java.io.Serializable;
import java.util.Date;

public class UserPo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String username;

	private String password;

	private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserPo [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday
				+ "]";
	}
	
}