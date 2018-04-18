package com.zby;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ResourceTest {

	@Test
	public void getFromClass() {
		InputStream inputStream = getClass().getResourceAsStream("class.txt");
		System.out.println(inputStream);
		try {
			if (null != inputStream) {
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Test
	public void getFromClassLoader() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("classloader.txt");
		System.out.println(inputStream);
		try {
			if (null != inputStream) {
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
