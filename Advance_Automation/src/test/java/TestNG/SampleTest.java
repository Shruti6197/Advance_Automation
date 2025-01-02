package TestNG;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(priority = 1)
	public void createContact() {
		System.out.println("Contact Created");
	}
	@Test(priority = 0)
	public void modifyContact() {
		System.out.println("Modifying Contact");
	}
	@Test(priority = -1)
	public void deleteContact() {
		System.out.println("Deleted Contact");
	}
}
