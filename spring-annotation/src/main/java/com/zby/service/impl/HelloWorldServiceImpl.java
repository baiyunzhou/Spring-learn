package com.zby.service.impl;

import org.springframework.stereotype.Service;

import com.zby.service.HelloWorldService;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String sayHello(String name) {
		return "Hello," + name + "!";
	}

}
