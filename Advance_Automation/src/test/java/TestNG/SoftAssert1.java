package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {
	
	@Test
	public void method1() {
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert soft = new SoftAssert();
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}
}
