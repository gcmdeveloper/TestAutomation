import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class testFacebookAccount {

	public static void main(String[] args) throws InterruptedException, Exception {

//		WebDriver driver = new FirefoxDriver();			
		WebDriver driver = new ChromeDriver();
		GenerateData d = new GenerateData();
		
		driver.manage().window().maximize();; // maximize the window
		
		driver.get("http://www.facebook.com"); // go to Facebook login page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(2000);

		//enter first name
		driver.findElement(By.xpath("//*[@id='u_0_1']")).sendKeys(d.generateRandomString(10));
		//enter last name
		driver.findElement(By.xpath("//*[@id='u_0_3']")).sendKeys(d.generateRandomData(12, true, true));
		Thread.sleep(1000);
		//enter password
		driver.findElement(By.xpath("//*[@id='u_0_d']")).sendKeys(d.generateRandomData(6, true, true));
		
		Thread.sleep(2000);
		
		//select month
		Select month = new Select(driver.findElement(By.xpath("//*[@id='month']")));
		month.selectByVisibleText("Mar");
		//select day
		Select day = new Select(driver.findElement(By.xpath("//*[@id='day']")));
		day.selectByValue("25");
		//select year
		Select year = new Select(driver.findElement(By.xpath("//*[@id='year']")));
		year.selectByValue("2000");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='u_0_g']")).click(); // click Female radio button
		driver.findElement(By.xpath("//*[@id='u_0_l']")).click(); // click Create account button
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/facebook.png"));
		
		System.out.println("Screenshot taken..");
		
		driver.quit();
	}

}
