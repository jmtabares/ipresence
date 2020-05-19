package com.ipresence.framework.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.ipresence.framework.data.interfaces.MainPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(MainPage.class.getName());
	private MainPageLocators locators;

	public MainPage() {
		locators = setLocators(MainPageLocators.class);
	}

	public void openApp() {
		open(environment.baseUrl());
	}

	public void setLocationByCity(String city, String country) {
		$(locators.searchInput()).sendKeys(city);
		$$(locators.cityResults()).shouldBe(CollectionCondition.sizeGreaterThan(0)).
				findBy(Condition.text(country)).click();
	}
}
