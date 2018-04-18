package com.zby;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinition {
	private String id;
	private String className;
	private Map<String, Object> genericProperties = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Map<String, Object> getGenericProperties() {
		return genericProperties;
	}

	public void setGenericProperties(Map<String, Object> genericProperties) {
		this.genericProperties = genericProperties;
	}

}
