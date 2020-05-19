package com.ipresence.framework.data.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources({
		"classpath:${env}/pages/searchResultsPageLocators.properties"
})
public interface SearchResultsPageLocators extends Config {
	String experiences();
}
