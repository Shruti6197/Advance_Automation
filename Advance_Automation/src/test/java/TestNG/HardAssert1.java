package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert1 {
	
	@Test
	public void method1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void method2() {
		String actData = "Qspider";
		String expData = "Qspider";
		Assert.assertEquals(actData, expData);
	}
	
	@Test
	public void method3() {
		int expValue = 1;
		int actValue = 10;
		Assert.assertEquals(actValue, expValue, "Assert is fail");
		System.out.println("Assert is Pass");
	}
	
	@Test
	public void method4() {
		String expData = "Data";
		String actData = "Data";
		Assert.assertNotEquals(actData, expData, "Assert is fail - both values are same");
		System.out.println("Assert is Pass - both values are not same");
	}
	
	@Test
	public void method5() {
		String expValue = "shruti";
		String actValue = "shruti";
		Assert.assertTrue(expValue.equalsIgnoreCase(actValue));
		System.out.println("Assert Pass");
	}
	
	@Test
	public void method6() {
		String expData = "automation";
		String actData = "automation";
		Assert.assertTrue(expData.equalsIgnoreCase(actData),"Assert Fail");
	}
	
	@Test
	public void method7() {
		String str1 = "Mumbai";
		String str2 = "Thane";
		Assert.assertFalse(str1.equalsIgnoreCase(str2),"Equal ==");
		System.out.println("Not Equal !=");
	}
	
	@Test
	public void method8() {
		String str = "";
		Assert.assertNull(str,"It is not null");
		System.out.println("It is null");
	}
	
	@Test
	public void method9() {
		String str = null;
		Assert.assertNull(str,"It is not null");
		System.out.println("It is null");
	}
	
	@Test
	public void method10() {
		String str1 = "Swarangi";
		String str2 = "swarangi";
		Assert.assertSame(str1, str2,"Not Same");
		System.out.println("Same");
	}
	
	@Test
	public void method11() {
		String str1 = "Swarangi";
		String str2 = "Swarang";
		Assert.assertNotSame(str1, str2,"Same");
		System.out.println("Not Same");
	}
	
	@Test
	public void method12() {
		String str1 = "Pune";
		String str2 = "Pune";
		Assert.assertNotSame(str1, str2,"Same");
		System.out.println("Not Same");
	}
	
	public void method13() {
	
	}
}