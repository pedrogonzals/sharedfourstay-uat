package com.fourstay.step_definitions;

import org.openqa.selenium.WebDriver;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {
	WebDriver driver;

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));

	}

	@When("^the user clicks on the loging link$")
	public void the_user_clicks_on_the_loging_link() throws Throwable {
		// // Write code here that turns the phrase above into concrete actions
		// driver.findElement(By.cssSelector(".not-login")).click();
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		// // Write code here that turns the phrase above into concrete actions
		// Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
	}

}
