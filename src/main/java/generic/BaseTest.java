package generic;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(generic.TestListeners.class)
public class BaseTest implements IautoConstants

{
	static WebDriver driver;
	{
	WebDriverManager.chromedriver().setup();
	}
   @BeforeMethod
   public void initialization()
 {
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("www.google.com");
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 }
   
   @AfterMethod
   public void quit() throws InterruptedException
   {
	   Thread.sleep(3000);
	   driver.quit();
   }
}
