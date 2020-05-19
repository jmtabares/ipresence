package com.ipresence.steps;

import com.ipresence.framework.pages.ExperienceDetailsPage;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;

public class ExperienceDetailsSteps {
	ExperienceDetailsPage experienceDetailsPage = new ExperienceDetailsPage();
	TestContext testContext;

	public ExperienceDetailsSteps(TestContext context) {
		testContext = context;
	}

	@When("I set the default pax number")
	public void iSelectAnyExperience() {
		experienceDetailsPage.switchToPage();
		experienceDetailsPage.setDefaultPaxValue();
	}

	@When("I book now")
	public void iBookNow() {
		String experiencePrice = experienceDetailsPage.getExperiencePrice();
		String experienceProduct = experienceDetailsPage.getExperienceProduct();
		String experienceDate = experienceDetailsPage.getExperienceDate();
		String experienceService = experienceDetailsPage.getExperienceService();
		testContext.scenarioContext.setContext(Context.EXPERIENCE_PRICE, experiencePrice);
		testContext.scenarioContext.setContext(Context.EXPERIENCE_PRODUCT, experienceProduct);
		testContext.scenarioContext.setContext(Context.EXPERIENCE_DATE, experienceDate);
		testContext.scenarioContext.setContext(Context.EXPERIENCE_SERVICE, experienceService);
		experienceDetailsPage.bookNow();
	}
}
