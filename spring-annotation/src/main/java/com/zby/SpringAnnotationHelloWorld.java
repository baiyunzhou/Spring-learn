package com.zby;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zby.event.CustomApplicationEvent;
import com.zby.event.CustomApplicationEventPublisher;
import com.zby.service.HelloWorldService;

@Configuration
@ComponentScan
public class SpringAnnotationHelloWorld {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationHelloWorld.class);
		HelloWorldService helloWorldService = applicationContext.getBean(HelloWorldService.class);
		System.out.println(helloWorldService.sayHello("World"));

		CustomApplicationEventPublisher customApplicationEventPublisher = applicationContext.getBean(CustomApplicationEventPublisher.class);
		customApplicationEventPublisher.callToPublish(new CustomApplicationEvent(new Date()));
		customApplicationEventPublisher.callToPublish(new Date());

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		applicationContext.close();
	}
}
