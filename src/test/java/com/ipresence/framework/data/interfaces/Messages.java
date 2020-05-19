package com.ipresence.framework.data.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:${env}/messages.properties"
})
public interface Messages extends Config {
	String creditCardError();

	String securityCodeError();

	String fullNameRequiredError();

	String firstNameRequiredError();

	String lastNameRequiredError();

	String contactInfoEmailError();

	String contactInfoPhoneError();
}
