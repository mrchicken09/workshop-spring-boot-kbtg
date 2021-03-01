package com.example.kbtg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class DemoServiceTest {
	
	
		@Test
		@DisplayName("ในการทำงานต้อง random = 5")
		public void random_5() {
			DemoService demoService = new DemoService();
			demoService.setRandom(new Random5());
			String actualResult = demoService.generateData("marut");
			assertEquals("marut5", actualResult);

		}
		
		@Test
		@DisplayName("ในการทำงานต้อง random = 2")
		public void random_2() {
			DemoService demoService = new DemoService();
			demoService.setRandom(new Random2());
			String actualResult = demoService.generateData("marut");
			assertEquals("marut2", actualResult);

		}

	}

	class Random5 extends Random {
		@Override
		public int nextInt(int bound) {
			return 5;
		}
	}
	
	class Random2 extends Random {
		@Override
		public int nextInt(int bound) {
			return 2;
		}
	}

