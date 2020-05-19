package com.ipresence.steps;

import com.ipresence.framework.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import static com.codeborne.selenide.Selenide.close;

public class HookSteps {
	@After
	public void closeBrowser() {
		close();
	}

	@AfterStep
	public void stepFailReport(Scenario scenario) {
		if (scenario.isFailed()) {
			Utils.reportError(scenario);
		}
	}
}