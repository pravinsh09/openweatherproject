package openweather;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Testcase1 
{
	
	WebDriver driver;
	
   @Test(priority=0,enabled=false)
   public void valid(){
	   
	   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		 System.setProperty("webdriver.chrome.driver","E:\\project\\Driver\\driver1\\chromedriver.exe");
		
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			
			
		//driver = new ChromeDriver(capabilities);
	
	 driver= new ChromeDriver();
	 driver.get("https://openweathermap.org/");
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	 driver.findElement(By.xpath("//input[@placeholder='Your city name']")).sendKeys("navi mumbai");
	 driver.findElement(By.xpath("//i[@class='fa fa-question-circle']//parent::button[@class='btn btn-orange']")).click();
	 String location=driver.findElement(By.xpath("//div[@id='forecast_list_ul']//tbody//i/ancestor::td//b//a")).getText();
	 String[] actualLoc=location.split(",");
	 System.out.println(actualLoc[0].trim());
	 Assert.assertEquals(actualLoc[0].trim(), "Navi Mumbai");  

   }
   
   @Test(priority=1,enabled=false)
   public void invalid()
   {
	   
	   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		 System.setProperty("webdriver.chrome.driver","E:\\project\\Driver\\driver1\\chromedriver.exe");
		
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);


		//driver = new ChromeDriver(capabilities);
	
	 driver= new ChromeDriver();
	 driver.get("https://openweathermap.org/");
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	 driver.findElement(By.xpath("//input[@placeholder='Your city name']")).sendKeys("Invalid data");
	 driver.findElement(By.xpath("	 //i[@class='fa fa-question-circle']//parent::button[@class='btn btn-orange']")).click();
	 String text=driver.findElement(By.xpath("//div[@id='forecast_list_ul']//div[@class='alert alert-warning']")).getText();
	
	 //verification
	 //System.out.println(text);
	 System.out.println(text.substring(2));
	/* String[] actualArray =text.split("\\s"); 
	 String actualString=actualArray[1]+" "+actualArray[2];
	 System.out.println(actualString);*/
	 Assert.assertEquals(text.substring(2), "Not found");
	 
	 
   }
   
   @Test(priority=2,enabled=true)
   public void homepage()
   {
	   
	   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		 System.setProperty("webdriver.chrome.driver","E:\\project\\Driver\\driver1\\chromedriver.exe");
		
	 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	 driver= new ChromeDriver();
	 driver.get("https://openweathermap.org/");
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	 String test =driver.getTitle();
	 System.out.println("testing--"+test);
	 
	 List<WebElement> list =driver.findElements(By.xpath("//a[@class='nav__link bg-hover-color']"));
	 System.out.println(list.size());
	 for(WebElement element :list){
		 
		 if(element.getText().equalsIgnoreCase("Guide")){
			 
			 Assert.assertEquals(element.getText(),"Guide");
			 System.out.println(element.getText());
		 }
	 }
	 
	 String Mapsmenu=driver.findElement(By.xpath("//a[@class='nav__link dropdown-toggle bg-hover-color']")).getText();
	 System.out.println(Mapsmenu);
	 Assert.assertEquals(Mapsmenu, "Maps");
	 //verify search button
	 String searchbtntext=driver.findElement(By.xpath("//i[@class='fa fa-question-circle']//parent::button[@class='btn btn-orange']")).getText();
	 System.out.println(searchbtntext);
	 
	 //verifying more button is pending
	 String temp =driver.findElement(By.xpath("//h3[@class='weather-widget__temperature']")).getText();
	 System.out.println(temp);
	 String[] str =temp.split(" ");
	 System.out.println(str[1]);
	 Assert.assertEquals(str[1], "°C");
   }
   
   @AfterMethod
   public void quit(){
	   
	   driver.quit();
   }
	
	
	
}
