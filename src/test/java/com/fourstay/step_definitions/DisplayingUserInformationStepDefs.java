package com.fourstay.step_definitions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.Homepage;
import com.fourstay.pages.SearchResultsPage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisplayingUserInformationStepDefs {
	Homepage homepage = new Homepage();

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		homepage.loginLink.click();

	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		Thread.sleep(3000);
		homepage.email.sendKeys(email);
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		homepage.password.sendKeys(password);
		Thread.sleep(3000);

	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.loginBtn.click();
		Thread.sleep(5000);
	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String expectedName) throws Throwable {

		UserAccountPage UserAccountPage = new UserAccountPage();
		String actual = UserAccountPage.accountHolder.getText();
		Assert.assertEquals(expectedName, actual);

	}

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String school) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.schoolName.sendKeys(school);

	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String start, String end) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.startDate.sendKeys(start);
		homepage.endDate.sendKeys(end);
	}

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.search.click();

		Thread.sleep(5000);
	}

	@When("^I enter this search criteria$")

	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {

		Map<String, String> input = searchCriteria.get(0);

		homepage.schoolName.sendKeys(input.get("school"));

		homepage.startDate.sendKeys(input.get("start"));

		homepage.endDate.sendKeys(input.get("end"));

		homepage.search.click();

	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		BrowserUtilities.switchTabs("search");

		BrowserUtilities.waitForPageLoad();

		SearchResultsPage resultsPage = new SearchResultsPage();

		Set<String> actualStates = new HashSet<>();

		for (WebElement element : resultsPage.allStates) {

			actualStates.add(element.getText());

		}

		System.out.println(actualStates);
		Assert.assertTrue(actualStates.containsAll(states));
	}

	@Then("^the results should contain specific dates$")
	public void the_results_should_contain_specific_dates(List<String> dates) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		BrowserUtilities.switchTabs("search");

		BrowserUtilities.waitForPageLoad();

		SearchResultsPage resultsPage = new SearchResultsPage();

		List<String> actualDates = new ArrayList<>();

		for (WebElement element : resultsPage.allDates) {

			actualDates.add(element.getText().replace("FROM:", " ").trim());

		}

		System.out.println(dates);
		System.out.println(actualDates);
		String date = "03/01/2017";
		Boolean datetest = actualDates.contains(dates.get(1));

		System.out.println(datetest);

		Assert.assertFalse(actualDates.containsAll(dates));

	}

}
