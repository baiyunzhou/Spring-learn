package com.zby.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class CustomEventProcesser implements ApplicationListener<CustomApplicationEvent> {

	@Override
	public void onApplicationEvent(CustomApplicationEvent event) {
		System.out.println("处理自定义的事件" + event);

	}

}
