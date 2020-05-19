package com.ipresence.framework.pages.checkoutPageComponents;

import com.codeborne.selenide.CollectionCondition;
import com.ipresence.framework.data.interfaces.CheckoutPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactInformationDetails {
	CheckoutPageLocators locators;

	public ContactInformationDetails(CheckoutPageLocators locators) {
		this.locators = locators;
	}

	public boolean isContactInformationEmailInputPresent() {
		return $(locators.contactInformationEmail()).exists();
	}

	public boolean isContactInformationCountryCodeInputPresent() {
		return $(locators.contactInformationPhoneCountryCode()).exists();
	}

	public boolean isContactInformationPhoneNumberPresent() {
		return $(locators.contactInformationPhoneNumber()).exists();
	}

	public void setContactInformationEmail(String contactInformationEmail) {
		$(locators.contactInformationEmail()).sendKeys(contactInformationEmail);
	}

	public void setContactInformationCountryCode(String contactInformationCountryCode) {
		$(locators.travelDetailsLastName()).selectOptionByValue(contactInformationCountryCode);
	}

	public void setContactInformationPhoneNumber(String contactInformationPhoneNumber) {
		$(locators.contactInformationPhoneNumber()).sendKeys(contactInformationPhoneNumber);
	}

	public String getContactEmailError() {
		return $(locators.contactEmailError()).getText();
	}

	public String getContactPhoneNumberError() {
		return $(locators.contactPhoneNumberError()).getText();
	}

}
