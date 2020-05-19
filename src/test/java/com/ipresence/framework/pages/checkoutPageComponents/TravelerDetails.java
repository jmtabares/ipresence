package com.ipresence.framework.pages.checkoutPageComponents;

import com.ipresence.framework.data.interfaces.CheckoutPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class TravelerDetails {
	CheckoutPageLocators locators;

	public TravelerDetails(CheckoutPageLocators locators) {
		this.locators = locators;
	}

	public boolean isTravelerFirstNameInputPresent() {
		return $(locators.travelDetailsFirstName()).exists();
	}

	public boolean isTravelerLastNameInputPresent() {
		return $(locators.travelDetailsLastName()).exists();
	}

	public boolean isTravelerSpecialInputPresent() {
		return $(locators.travelDetailsSpecial()).exists();
	}

	public void setTravelerFirstName(String travelerFirstName) {
		$(locators.travelDetailsFirstName()).sendKeys(travelerFirstName);
	}

	public void setTravelerLastName(String travelerLastName) {
		$(locators.travelDetailsLastName()).sendKeys(travelerLastName);
	}

	public void setTravelerSpecial(String travelerSpecial) {
		$(locators.travelDetailsSpecial()).sendKeys(travelerSpecial);
	}

	public String getTravelerFirstNameError() {
		return $(locators.travelerFirstNameError()).getText();
	}

	public String getTravelerLastNameError() {
		return $(locators.travelerLastNameError()).getText();
	}
}
