package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.junit.Assert;

import BasePage.BasePage;
import cucumber.api.java.en.Then;

public class HomePage extends BasePage {
	

	@FindBy(xpath="//a[@class='nav__link dropdown-toggle bg-hover-color']")
	WebElement mapsMenu;
	
	@FindBy(xpath="//a[@class='nav__link bg-hover-color']")
	List<WebElement> allMenuList;
	
	@FindBy(xpath="//i[@class='fa fa-question-circle']//parent::button[@class='btn btn-orange']")
	WebElement Searchbutton;
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void verify_menus_in_homepage(String menuname) throws Throwable {
	   
		if (mapsMenu.getText().equalsIgnoreCase(menuname)) {
			String menu = mapsMenu.getText();
			System.out.println(menu);
			Assert.assertEquals(menu, menuname);
		} else {
			List<WebElement> list = allMenuList;
			System.out.println(list.size());
			for (WebElement element : list) {

				if (element.getText().equalsIgnoreCase(menuname)) {

					Assert.assertEquals(element.getText(), menuname);
					System.out.println(element.getText());
				}
			}

		}
	
	}
	
	public void verifySearchbuttonlabel(){
		
		String searchbtntext=Searchbutton.getText().trim();
		 System.out.println(searchbtntext);
		 Assert.assertEquals(searchbtntext,"Search");
	}
	

}
