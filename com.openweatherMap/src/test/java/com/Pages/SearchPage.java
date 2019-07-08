package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import BasePage.BasePage;



public class SearchPage extends BasePage {
	
	
	public  SearchPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Your city name']")
	WebElement CitySearchtxt;
	
	@FindBy(xpath="//i[@class='fa fa-question-circle']//parent::button[@class='btn btn-orange']")
	WebElement searchbutton;
	
	@FindBy(xpath="//div[@id='forecast_list_ul']//tbody//i/ancestor::td//b//a")
	WebElement locationlabel;
	
	@FindBy(xpath="//div[@id='forecast_list_ul']//div[@class='alert alert-warning']")
	WebElement NotFoundmsglabel;
	
	
	
	
	public void enterCitySearch(String city){
		
		CitySearchtxt.sendKeys(city);
		
	}
	
	public void ClickSeachbutton(){
	
		searchbutton.click();
		
	}
	
	public void VerifyCityname(String datacityname){
		
		 String location=locationlabel.getText();
		 String[] actualLoc=location.split(",");
		 System.out.println(actualLoc[0].trim());
		 Assert.assertEquals(actualLoc[0].trim(), datacityname);  
	}
	
	public void verifyinvalidMsg(){
		
		
		String text=NotFoundmsglabel.getText();
		
		 System.out.println(text.substring(2));
		 Assert.assertEquals(text.substring(2), "Not found");
	}
}
