package com.zby.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ArbitraryEventProcesser {
	@EventListener
	public void dealwithArbitraryEvent(Object object) {
		System.out.println("处理任意事件：" + object);
	}
}
