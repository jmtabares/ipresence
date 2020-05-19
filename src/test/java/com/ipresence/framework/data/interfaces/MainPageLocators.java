package com.ipresence.framework.data.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources({
		"classpath:${env}/pages/mainPageLocators.properties"
})
public interface MainPageLocators extends Config {
	String tours();

	String searchInput();

	String cityResults();
}
