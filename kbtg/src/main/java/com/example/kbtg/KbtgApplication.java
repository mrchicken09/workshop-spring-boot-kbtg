package com.example.kbtg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KbtgApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(KbtgApplication.class, args);
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println(context.getBeanDefinitionCount());
	}

}
