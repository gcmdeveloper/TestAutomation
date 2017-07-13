package testNGtrial;

import org.testng.annotations.Test;

public class firstTestNGScript {

	@Test(priority=1, description="This is a test to log in the application.")
	public void loginApplication() {
		System.out.println("Log in application..");
	}
	
	@Test(priority=2)
	public void selectItems() {
		System.out.println("Items selected..");
	}
	
	@Test(priority=3)
	public void checkOut() {
		System.out.println("Check out items..");
	}
	
	
}
