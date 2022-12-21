package com.stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefination {

	
    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
        System.out.println("User is on login page");
    }

    @When("^User login with user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_with_user_name_something_and_password_something(String userName, String password) throws Throwable {
    	System.out.println("User login with userName " + userName + " and password " +password);
    }

    
    @Then("Home page is populated as \"([^\"]*)\"$" )
    public void home_page_is_populated_as(boolean isPopulated) {
    	if (isPopulated==true) {
    		System.out.println("Home page is populated");
    	}
    	else {
    		System.out.println("Home page is not populated");
    	}
    }

    @And("^User deatils are populated on home page$")
    public void user_deatils_are_populated_on_home_page() throws Throwable {
    	System.out.println("User deatils are populated on home page");
    }
	
}