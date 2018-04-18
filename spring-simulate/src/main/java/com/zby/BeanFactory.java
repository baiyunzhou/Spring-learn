package com.zby;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
	private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

	public BeanFactory() {
		init();
	}

	private void init() {
		// 定义person
		BeanDefinition personDefinition = new BeanDefinition();
		personDefinition.setId("person");
		personDefinition.setClassName("com.zby.Person");
		personDefinition.getGenericProperties().put("name", "zhangsan");
		personDefinition.getGenericProperties().put("driveable", "car");
		beanDefinitions.put(personDefinition.getId(), personDefinition);
		// 定义car
		BeanDefinition driveableDefinition = new BeanDefinition();
		driveableDefinition.setId("car");
		driveableDefinition.setClassName("com.zby.Car");
		beanDefinitions.put(driveableDefinition.getId(), driveableDefinition);
	}

	public Object getBean(String beanName) {
		Object result = null;
		if (beanDefinitions.get(beanName) != null) {
			BeanDefinition beanDefinition = beanDefinitions.get(beanName);
			String className = beanDefinition.getClassName();
			try {
				result = Class.forName(className).newInstance();
				setGenericProperties(result, beanDefinition);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
			return result;
		}

		return result;
	}

	private void setGenericProperties(Object object, BeanDefinition beanDefinition)
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = beanDefinition.getGenericProperties();
		for (String key : map.keySet()) {
			Field field = object.getClass().getDeclaredField(key);
			Object value = null;
			// 判断如果不是基础类型，那么应该是需要注入其他bean
			if (field.getType().getName() != "java.lang.String") {
				value = getBean(map.get(key).toString());
			} else {
				value = map.get(key);
			}
			field.setAccessible(true);
			field.set(object, value);
			// System.out.println(field.getType());

		}
	}
}