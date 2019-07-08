package stepsDefinations;

import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import BasePage.BasePage;
import cucumber.api.java.After;

public class Hook extends BasePage {
	
	   
	
		 @Before	
		 public void beforeScenario(){
			 System.out.println("browser");
			 System.setProperty("webdriver.chrome.driver","E:\\project\\Driver\\driver1\\chromedriver.exe");
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);

				//driver = new ChromeDriver(capabilities);
			 
			 driver= new ChromeDriver();
			
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 driver.get("http://openweathermap.org");
			 	 
			}
		
	
	
	@After
	public void tearDown(){
		
		System.out.println("Afterclass testing");
		driver.quit();
	}
}
