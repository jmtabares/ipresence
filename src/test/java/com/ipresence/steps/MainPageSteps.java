package com.ipresence.steps;

import com.ipresence.framework.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MainPageSteps {
	MainPage mainPage = new MainPage();

	@Given("I open browser")
	public void iOpenBrowser() {
		mainPage.openApp();
	}

	@And("I search for city {string} on country {string}")
	public void iSearchForCityOnCountry(String city, String country) {
		mainPage.setLocationByCity(city, country);
	}

}
