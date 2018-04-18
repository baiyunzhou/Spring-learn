package com.zby.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean的生命周期->new->postProcessBeforeInitialization->bean.init->
 * postProcessAfterInitialization->using->bean.destroy
 * 
 * @author zhoubaiyun
 *
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization->" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization->" + beanName);
		return bean;
	}

}
