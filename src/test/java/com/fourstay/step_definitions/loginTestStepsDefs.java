package com.fourstay.step_definitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.Homepage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginTestStepsDefs {
	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Homepage homepage = new Homepage();
		homepage.loginLink.click();
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

//		wait.until(ExpectedConditions.visibilityOf(homepage.loginLink));

		// Thread.sleep(3000);

		homepage.email.sendKeys(ConfigurationReader.getProperty("host.username"));

		// wait.until(ExpectedConditions.t;

		Thread.sleep(3000);

		homepage.password.sendKeys(ConfigurationReader.getProperty("host.password"));

		Thread.sleep(3000);

		homepage.loginBtn.click();
	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 5000);
//		wait.until(ExpectedConditions.urlContains("dashboard"));

	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		Homepage homepage = new Homepage();
		homepage.loginLink.click();
		Thread.sleep(3000);

		homepage.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Thread.sleep(3000);

		homepage.password.sendKeys(ConfigurationReader.getProperty("guest.password"));
		Thread.sleep(1000);
		homepage.loginBtn.click();
	}

}
