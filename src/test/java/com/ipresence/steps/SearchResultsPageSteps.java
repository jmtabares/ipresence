package com.ipresence.steps;

import com.ipresence.framework.pages.MainPage;
import com.ipresence.framework.pages.SearchResultPage;
import io.cucumber.java.en.When;

public class SearchResultsPageSteps {
	SearchResultPage searchResultPage = new SearchResultPage();

	@When("I select any experience")
	public void iSelectAnyExperience() {
		searchResultPage.selectExperience();
	}
}
