package com.zby.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomApplicationEventPublisher {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void callToPublish(ApplicationEvent applicationEvent) {
		applicationEventPublisher.publishEvent(applicationEvent);
	}

	public void callToPublish(Object object) {
		applicationEventPublisher.publishEvent(object);
	}
}
