
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestPopUp {

	@Test (description="This is to test the switching of windows and closing them.")
	public void TestPopUpWindow() {

		WebDriver driver = new ChromeDriver(); // open Chrome browser

		driver.manage().window().maximize(); //maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //implicit wait of 30secs

		driver.get("http://www.naukri.com"); // open the URL

		String parent_window = driver.getWindowHandle(); // returns the parent window as a string

		Set<String> n1 = driver.getWindowHandles(); // returns the number of windows opened by the WebDriver and return as a String

		Iterator<String> i1 = n1.iterator(); // it will iterate the number of windows

		while (i1.hasNext()) {

			String child_window = i1.next();

			// This will check if the parent window is not equal to the child window 
			if (!parent_window.equals(child_window)) {

				driver.switchTo().window(child_window); // switch to child window
				System.out.println(driver.switchTo().window(child_window).getTitle()); // gets the title of the current window
				driver.close(); // close the child window
			}
		}
		// once there is no more child window, it will now switch to the parent window
		driver.switchTo().window(parent_window);	
		driver.close();
		
	}
	
	@Test(description="This is to test the scrolling down of the page.")
	public void ScrollPageDown() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		((JavascriptExecutor)driver).executeScript("scroll(0,400)"); // scrolls the page 400 pixels down 
		driver.close();
		
	}
	
	
	

}
