package com.zby;

public class BeanFactoryTest {

	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		Person person = (Person) beanFactory.getBean("person");
		person.drive();

	}

}
