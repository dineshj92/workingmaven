package com.bix.selenium.hybrid;

public class SampleEnum {
	
	enum Frameworks{TESTNG, JUNIT;}

	public static void main(String[] args) {
		String fw = "JUNIT";
		Frameworks fw1 = Frameworks.JUNIT;
		System.out.println(Frameworks.valueOf(fw));
	}

}
