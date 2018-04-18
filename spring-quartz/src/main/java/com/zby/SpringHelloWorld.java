package com.zby;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorld {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applicationContext.close();

	}
}
