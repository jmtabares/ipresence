package com.ipresence.framework.pages.checkoutPageComponents;

import com.codeborne.selenide.SelenideElement;
import com.ipresence.framework.data.interfaces.CheckoutPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PaymentDetails {
	CheckoutPageLocators locators;

	public PaymentDetails(CheckoutPageLocators locators) {
		this.locators = locators;
	}

	private void set(SelenideElement elem, boolean value) {
		elem.click();
	}

	public void selectCCPaymentMethod() {
		set($(locators.paymentCreditCard()), true);
	}

	public void selectGPPaymentMethod() {
		set($(locators.paymentGooglePay()), true);
	}

	public void selectPPPaymentMethod() {
		set($(locators.paymentPayPal()), true);
	}

	public void selectAPPaymentMethod() {
		set($(locators.paymentApplePay()), true);
	}

	private boolean isPresent(SelenideElement elem) {
		boolean result;
		switchTo().frame(locators.paymentCreditCardIframe());
		result = elem.exists();
		switchTo().defaultContent();
		return result;
	}

	public boolean isCardholderNameInputPresent() {
		return isPresent($(locators.paymentCreditCardCardHolderName()));
	}

	public boolean isCreditCardNumberInputPresent() {
		return isPresent($(locators.paymentCreditCardNumber()));
	}

	public boolean isExpirationDateMonthInputPresent() {
		return isPresent($(locators.paymentCreditCardExpMonth()));
	}

	public boolean isExpirationDateYearInputPresent() {
		return isPresent($(locators.paymentCreditCardExpYear()));
	}

	public boolean isCreditCardSecCodePresent() {
		return isPresent($(locators.paymentCreditCardSecCode()));
	}

	public boolean isCreditCardCountryPresent() {
		return isPresent($(locators.paymentCreditCardCountry()));
	}

	private void enterValue(SelenideElement elem, String value) {
		switchTo().frame(locators.paymentCreditCardIframe());
		elem.sendKeys(value);
		switchTo().defaultContent();
	}

	private void selectByValue(SelenideElement elem, String value) {
		switchTo().frame(locators.paymentCreditCardIframe());
		elem.selectOptionByValue(value);
		switchTo().defaultContent();
	}

	public void setCardholderNameInput(String cardholderName) {
		$(locators.paymentCreditCardCardHolderName()).sendKeys(cardholderName);
	}

	public void setCreditCardNumber(String creditCardNumber) {
		enterValue($(locators.paymentCreditCardNumber()), creditCardNumber);
	}

	public void setExpirationDateMonth(String expirationDateMonth) {
		selectByValue($(locators.paymentCreditCardExpMonth()), expirationDateMonth);
	}

	public void setExpirationDateYear(String expirationDateYear) {
		selectByValue($(locators.paymentCreditCardExpYear()), expirationDateYear);
	}

	public void setCreditCardSecCode(String creditCardSecCode) {
		enterValue($(locators.paymentCreditCardSecCode()), creditCardSecCode);
	}

	public void setCreditCardCountry(String creditCardCountry) {
		$(locators.paymentCreditCardCountry()).selectOptionByValue(creditCardCountry);
	}

	private String getError(SelenideElement elem) {
		String result;
		switchTo().frame(locators.paymentCreditCardIframe());
		result = elem.getText();
		switchTo().defaultContent();
		return result;
	}

	public String getCreditCardError() {
		return getError($(locators.creditCardError()));
	}

	public String getSecurityCodeError() {
		return getError($(locators.securityCodeError()));
	}

	public String getCreditCardFullNameError() {
		return $(locators.paymentFullNameError()).getText();
	}
	private boolean getClassError(SelenideElement elem) {
		boolean result;
		switchTo().frame(locators.paymentCreditCardIframe());
		result = elem.getAttribute("class").contains("hasError");
		switchTo().defaultContent();
		return result;
	}
	public boolean expDateMonthHasError() {
		return getClassError($(locators.paymentCreditCardExpMonth()));
	}

	public boolean expDateYearHasError() {
		return getClassError($(locators.paymentCreditCardExpYear()));
	}
}
