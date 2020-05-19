package com.ipresence.framework.pages;

import com.ipresence.framework.data.interfaces.ExperienceDetailsPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ExperienceDetailsPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(ExperienceDetailsPage.class.getName());
	private ExperienceDetailsPageLocators locators;

	public ExperienceDetailsPage() {
		locators = setLocators(ExperienceDetailsPageLocators.class);
	}

	public void switchToPage() {
		switchTo().window(1);
	}

	public void setDefaultPaxValue() {
		$(locators.travelers()).click();
		forceJSClick($(locators.applyPax()));
	}

	public void bookNow() {
		$(locators.chosen()).find(By.cssSelector(locators.bookNow())).click();
	}

	public String getExperiencePrice() {
		return $(locators.chosen()).find(By.cssSelector(locators.price())).getText();
	}
	public String getExperienceProduct(){ return $(locators.productTitle()).getText();}
	public String getExperienceDate(){ return $(locators.date()).getValue();}
	public String getExperienceService(){ return $(locators.service()).getText();}
}
