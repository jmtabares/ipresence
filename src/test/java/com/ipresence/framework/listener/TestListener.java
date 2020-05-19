package com.ipresence.framework.listener;
import com.ipresence.framework.data.interfaces.Environment;
import com.codeborne.selenide.Configuration;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListener implements ConcurrentEventListener {
	private static final Logger logger = LogManager.getLogger(TestListener.class.getName());
	private EventHandler<TestRunStarted> setup = new EventHandler<TestRunStarted>() {
		@Override
		public void receive(TestRunStarted testRunStarted) {
			String environmentProperty = System.getProperty("test.environment"); //here you read your environment name
			ConfigFactory.setProperty("env", environmentProperty);
			Environment environment;
			ConfigFactory.setProperty("env", environmentProperty);
			environment = ConfigFactory.create(Environment.class);
			boolean install = Boolean.parseBoolean(System.getProperty("install", String.valueOf(environment.needCreateTestData())));
			boolean headless = Boolean.parseBoolean(System.getProperty("headless", String.valueOf(environment.headless())));
			System.setProperty("headless", String.valueOf(headless));
			Configuration.timeout = 9000;
			Configuration.startMaximized=true;
			if (environment.needCreateUser()) {
				try {
					//data users  creation on DB
				} catch (Exception e) {
					logger.catching(e);
				}
			}
			if (environment.needCreateTestData()) {
				//test data creation on DB
			}
		}
	};
	private EventHandler<TestRunFinished> teardown = new EventHandler<TestRunFinished>() {
		@Override
		public void receive(TestRunFinished testRunFinished) {
			Environment testEnvironment;
			testEnvironment = ConfigFactory.create(Environment.class);
			if (testEnvironment.needCreateTestData()) {
				//delete any created data at the suites ends
			}
		}
	};

	@Override
	public void setEventPublisher(EventPublisher eventPublisher) {
		eventPublisher.registerHandlerFor(TestRunStarted.class, setup);
		eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);
	}
}