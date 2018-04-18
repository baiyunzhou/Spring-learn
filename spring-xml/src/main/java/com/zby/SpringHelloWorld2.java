package com.zby;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zby.service.HelloWorldService;

@SuppressWarnings("deprecation")
public class SpringHelloWorld2 {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		// HelloWorldService helloWorldService =
		// xmlBeanFactory.getBean(HelloWorldService.class);
		HelloWorldService helloWorldService = (HelloWorldService) xmlBeanFactory.getBean("helloWorldService");
		System.out.println(helloWorldService.sayHello("World"));

	}

}
