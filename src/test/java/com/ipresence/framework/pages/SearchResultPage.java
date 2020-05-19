package com.ipresence.framework.pages;

import com.ipresence.framework.data.interfaces.SearchResultsPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchResultPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(SearchResultPage.class.getName());
	private SearchResultsPageLocators locators;

	public SearchResultPage() {
		locators = setLocators(SearchResultsPageLocators.class);
	}

	public void selectExperience() {
		$$(locators.experiences()).get(0).shouldBe(visible).click();
	}
}
