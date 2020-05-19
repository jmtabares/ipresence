package com.ipresence.framework.pages.checkoutPageComponents;

import com.codeborne.selenide.Condition;
import com.ipresence.framework.data.interfaces.Environment;
import com.ipresence.framework.data.interfaces.Messages;
import cucumber.TestContext;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.*;

public class BaseSteps {

	private static final Logger logger = LogManager.getLogger(BaseSteps.class.getName());

	protected Environment environment;
	protected Messages messages;
	protected Condition clickable = and("can be clicked", visible, enabled);
	private TestContext testContext;

	public BaseSteps(TestContext context) {
		environment = ConfigFactory.create(Environment.class);
		messages = ConfigFactory.create(Messages.class);
		testContext = context;
	}
}
