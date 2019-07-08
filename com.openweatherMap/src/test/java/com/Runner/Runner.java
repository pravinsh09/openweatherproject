package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;




	
	@RunWith(Cucumber.class)
	@CucumberOptions(

				//format = {"pretty", "json:target/"}
		       features = {"src/test/java/com/Features"},   
				glue = {"stepsDefinations"},
				 tags ={"@Home"}
		    )
	public class Runner{
		
		
		

	}


