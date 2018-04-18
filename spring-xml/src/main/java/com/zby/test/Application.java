package com.zby.test;

import org.springframework.util.ClassUtils;

public class Application {

	public static void main(String[] args) {
		try {
			Class<?> optional = ClassUtils.forName("java.util.Optional", Application.class.getClassLoader());
			System.out.println(optional);
		} catch (ClassNotFoundException e) {
			System.out.println("Java 8 not available - Optional references simply not supported then.");
		}

		try {
			Class<?> provider = ClassUtils.forName("javax.inject.Provider", Application.class.getClassLoader());
			System.out.println(provider);
		} catch (ClassNotFoundException e) {
			System.out.println("JSR-330 API not available - Provider interface simply not supported then.");
		}

	}

}
