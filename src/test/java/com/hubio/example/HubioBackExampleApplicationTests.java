package com.hubio.example;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HubioBackExampleApplicationTests {

	@Test
	public void contextLoads() {
		String[] arguments = new String[] {"--spring.profiles.active=development"};
		
		HubioBackExampleApplication.main(arguments);
	}

}
