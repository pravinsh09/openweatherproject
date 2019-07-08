package stepsDefinations;

import java.util.Map;

import com.Pages.HomePage;
import com.Pages.SearchPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Searchpagetest {
	
	HomePage homepg = new HomePage();
	SearchPage srchpg = new SearchPage();
	
	
	@Given("^I enter Invalid cityname to search$")
	public void i_enter_Invalid_cityname_to_search(DataTable City) throws Throwable {
		
		for(Map<String,String> data : City.asMaps(String.class, String.class) ){
		System.out.println(data.get("InvalidCityName"));
		srchpg.enterCitySearch(data.get("InvalidCityName"));
		}
	}

	@Then("^Verify message NotFound$")
	public void verify_message_NotFound() throws Throwable {
	   
		srchpg.verifyinvalidMsg();
	}

	@Given("^I enter valid \"([^\"]*)\" in Searchfield$")
	public void i_enter_valid_in_field(String validCityname) throws Throwable {
	 
		System.out.println("validCityname--"+validCityname);
		srchpg.enterCitySearch(validCityname);
	}

	@Given("^Click on Search button$")
	public void click_on_Search_button() throws Throwable {
		srchpg.ClickSeachbutton();
	
	}

	@Then("^Verify \"([^\"]*)\" in Home Page$")
	public void verify_in_Home_Page(String cityname) throws Throwable {
	  
		srchpg.VerifyCityname(cityname);
	}	

}
