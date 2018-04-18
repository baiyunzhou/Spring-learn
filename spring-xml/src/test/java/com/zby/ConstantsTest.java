package com.zby;

import org.junit.Test;
import org.springframework.core.Constants;

public class ConstantsTest {
	@Test
	public void testConstants(){
		Constants constants=new Constants(GeneralClass.class);
		System.out.println(constants.asNumber("age"));
		System.out.println(constants.asString("NAME"));
	}
}
