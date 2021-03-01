package com.example.kbtg;

import java.util.Random;

import javax.management.RuntimeErrorException;

public class DemoService {
	Random random;
	public void setRandom(Random random) {
		this.random = random;
		
	}

	public String generateData(String name) {
		int number = random.nextInt(10); // random 0-9
		if(number >=5 && number <=8) {
			return name+ number;
		}
		throw new RuntimeException("Invalid Number with " +number);
	}

//	public static void main(String[] args) {
//		//Anonymous Class
//		Random random = new Random() {
//
//			@Override
//			public int nextInt(int bound) {
//				return 5;
//			}
//			
//		}; //dependency
//		
//		DemoService demoService = new DemoService();
//		
//		demoService.setRandom(new Random5());
//		
//		System.out.println(demoService.generateData("marut"));
//	}
	


}

//class Random5 extends Random {
//    @Override
//    public int nextInt(int bound) {
//        return 5;
//    }
// }

