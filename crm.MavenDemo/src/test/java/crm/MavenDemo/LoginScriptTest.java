package crm.MavenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScriptTest {
	
	@Test
	
	public void LogintoVtiger() {
		
	
	WebDriver driver = null;
	String browser = System.getProperty("browser");
	String url = System.getProperty("url");
	String username = System.getProperty("admin");
	String password = System.getProperty("admin");
	
	if (browser.equalsIgnoreCase(browser)) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("launched browser is " + browser);

	} else if (browser.equalsIgnoreCase(browser)) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println("launched browser is " + browser);
	} else {
		System.out.println("specify valid browser");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);

	/* step 1 : login to app */

	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	/* step 2 :logout the app*/
	
	WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(adminImg).perform();
	driver.findElement(By.linkText("Sign Out"));
	driver.quit();
  }

}
