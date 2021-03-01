package com.example.kbtg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoServiceTest {

	@Test
	@DisplayName("ในการทำงานต้อง random = 5")
	public void random_5() {
		DemoService demoService = new DemoService();
		demoService.setRandom(new RandomNumber(5));
		String actualResult = demoService.generateData("marut");
		assertEquals("marut5", actualResult);

	}


	@Test
	public void throw_exception_1() {
		DemoService demoService = new DemoService();
		demoService.setRandom(new RandomNumber(1));
		// JAVA Style
		try {
			demoService.generateData("marut");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid number with 1", e.getMessage());
		}

	}
	@Test
	public void throw_exception_2() {
		 DemoService demoService = new DemoService();
	        demoService.setRandom(new RandomNumber(1));
	        // JUnit 5 style
	        Exception exception = assertThrows(RuntimeException.class, () -> {
	            demoService.generateData("marut");
	        });
	        assertEquals("Invalid number with 1", exception.getMessage());

	}

}

class RandomNumber extends Random {
	private final int result;

	RandomNumber(int result) {
		this.result = result;
	}

	@Override
	public int nextInt(int bound) {
		return result;
	}
}
