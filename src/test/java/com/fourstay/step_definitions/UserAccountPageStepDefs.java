package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.UserAccountPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserAccountPageStepDefs {
	UserAccountPage userAccPage = new UserAccountPage();

	@When("^I enter school name in User Account Page \"([^\"]*)\"$")
	public void i_enter_school_name_in_User_Account_Page(String school) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		userAccPage.schoolName.sendKeys(school + Keys.ENTER);

	}

	@When("^I enter dates User Account Page \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_User_Account_Page_and(String start, String end) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		userAccPage.startDate.sendKeys(start);
		userAccPage.endDate.sendKeys(end);
	}

	@Then("^the results should contain price tags$")
	public void the_results_should_contain_price_tags() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		UserAccountPage userAccPage = new UserAccountPage();
		Set<String> actualPriceTags = new HashSet<>();

		Thread.sleep(5000);

		for (WebElement element : userAccPage.allPriceTags) {

			actualPriceTags.add(element.getText());

		}

		System.out.println(actualPriceTags);

	}

}
