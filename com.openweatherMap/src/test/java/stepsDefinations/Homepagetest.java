package stepsDefinations;


import com.Pages.HomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Homepagetest {
	
	
	HomePage homepage = new HomePage();
	

	@And("^user is in openweathermap homepage$")
	public void user_is_in_openweathermap_homepage() throws Throwable {
		homepage.verifySearchbuttonlabel();
	}
	
	@Then("^verify \"([^\"]*)\" in homepage$")
	public void verify_in_homepage(String menuName) throws Throwable {
	    
		homepage.verify_menus_in_homepage(menuName);
	}

	

	

	
}
