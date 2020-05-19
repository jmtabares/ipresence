package com.ipresence.framework.data.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources({
		"classpath:${env}/pages/experienceDetailsPageLocators.properties"
})
public interface ExperienceDetailsPageLocators extends Config {
	String travelers();

	String applyPax();

	String bookNow();

	String chosen();

	String price();

	String productTitle();

	String date();

	String service();
}
