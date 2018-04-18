package com.zby.custom;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class CustomBeanDefinationParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return UserTag.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		builder.addPropertyValue("userNmae", element.getAttribute("userName"));
		builder.addPropertyValue("password", element.getAttribute("passwords"));
	}

}
