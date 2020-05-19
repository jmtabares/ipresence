package com.ipresence.framework.data.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:${env}/env.properties"
})
public interface Environment extends Config {
	boolean needCreateTestData();

	boolean needCreateUser();

	boolean headless();

	String baseUrl();
}
