package com.ipresence.framework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Function;
import com.ipresence.framework.data.interfaces.Environment;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {
	private static final Logger logger = LogManager.getLogger(BasePage.class.getName());

	protected Environment environment;
	protected Condition clickable = and("can be clicked", visible, enabled);

	public BasePage() {
		environment = ConfigFactory.create(Environment.class);
	}

	static WebDriverWait waitFor() {
		return waitFor(4);
	}

	public static WebDriverWait waitFor(int seconds) {
		return new WebDriverWait(getWebDriver(), seconds);
	}

	public static void waitForPage() {
		waitFor().until((Function<? super WebDriver, Boolean>) d -> ((JavascriptExecutor) getWebDriver()).executeScript("return document.readyState").equals("complete"));
	}

	protected <T extends Config> T setLocators(Class locators) {
		return (T) ConfigFactory.create(locators);
	}

	protected ArrayList<String> getValueStringListFromElemCollection(ElementsCollection elemList) {
		ArrayList<String> returnList = new ArrayList<>();
		for (SelenideElement item : elemList) {
			returnList.add(item.getValue());
		}
		return returnList;
	}

	protected ArrayList<String> getStringListFromElemCollection(ElementsCollection elemList) {
		ArrayList<String> returnList = new ArrayList<>();
		for (SelenideElement item : elemList) {
			returnList.add(item.getText());
		}
		return returnList;
	}

	protected void forceJSClick(SelenideElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript("arguments[0].click();", element);
	}
}