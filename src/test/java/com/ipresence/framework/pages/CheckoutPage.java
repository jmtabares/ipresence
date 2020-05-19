package com.ipresence.framework.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.ipresence.framework.data.interfaces.CheckoutPageLocators;
import com.ipresence.framework.pages.checkoutPageComponents.ContactInformationDetails;
import com.ipresence.framework.pages.checkoutPageComponents.OrderDetails;
import com.ipresence.framework.pages.checkoutPageComponents.PaymentDetails;
import com.ipresence.framework.pages.checkoutPageComponents.TravelerDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CheckoutPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(CheckoutPage.class.getName());
	private CheckoutPageLocators locators;
	PaymentDetails paymentDetails;
	TravelerDetails travelerDetails;
	OrderDetails orderDetails;
	ContactInformationDetails contactInformationDetails;

	public CheckoutPage() {
		locators = setLocators(CheckoutPageLocators.class);
		paymentDetails = new PaymentDetails(locators);
		travelerDetails = new TravelerDetails(locators);
		orderDetails = new OrderDetails(locators);
		contactInformationDetails = new ContactInformationDetails(locators);
	}

	public void waitForPageToLoad() {
		$("#checkoutPageHeader").shouldBe(Condition.visible);
		$("#rightHandRail").shouldBe(Condition.visible);
	}

	public void selectCCPaymentMethod() {
		paymentDetails.selectCCPaymentMethod();
	}

	public void selectGPPaymentMethod() {
		paymentDetails.selectGPPaymentMethod();
	}

	public void selectPPPaymentMethod() {
		paymentDetails.selectPPPaymentMethod();
	}

	public void selectAPPaymentMethod() {
		paymentDetails.selectAPPaymentMethod();
	}

	public boolean isCardholderNameInputPresent() {
		return paymentDetails.isCardholderNameInputPresent();
	}

	public boolean isCreditCardNumberInputPresent() {
		return paymentDetails.isCreditCardNumberInputPresent();
	}

	public boolean isExpirationDateMonthInputPresent() {
		return paymentDetails.isExpirationDateMonthInputPresent();
	}

	public boolean isExpirationDateYearInputPresent() {
		return paymentDetails.isExpirationDateYearInputPresent();
	}

	public boolean isCreditCardSecCodePresent() {
		return paymentDetails.isCreditCardSecCodePresent();
	}

	public boolean isCreditCardCountryPresent() {
		return paymentDetails.isCreditCardCountryPresent();
	}

	public void setCardholderNameInput(String cardholderName) {
		paymentDetails.setCardholderNameInput(cardholderName);
	}

	public void setCreditCardNumber(String creditCardNumber) {
		paymentDetails.setCreditCardNumber(creditCardNumber);
	}

	public void setExpirationDateMonth(String expirationDateMonth) {
		paymentDetails.setExpirationDateMonth(expirationDateMonth);
	}

	public void setExpirationDateYear(String expirationDateYear) {
		paymentDetails.setExpirationDateYear(expirationDateYear);
	}

	public void setCreditCardSecCode(String creditCardSecCode) {
		paymentDetails.setCreditCardSecCode(creditCardSecCode);
	}

	public void setCreditCardCountry(String creditCardCountry) {
		paymentDetails.setCreditCardCountry(creditCardCountry);
	}

	public String getCreditCardError() {
		return paymentDetails.getCreditCardError();
	}

	public String getSecurityCodeError() {
		return paymentDetails.getSecurityCodeError();
	}

	public String getCreditCardFullNameError() {
		return paymentDetails.getCreditCardFullNameError();
	}

	public boolean isTravelerFirstNameInputPresent() {
		return travelerDetails.isTravelerFirstNameInputPresent();
	}

	public boolean isTravelerLastNameInputPresent() {
		return travelerDetails.isTravelerLastNameInputPresent();
	}

	public boolean isTravelerSpecialInputPresent() {
		return travelerDetails.isTravelerSpecialInputPresent();
	}

	public void setTravelerFirstName(String travelerFirstName) {
		travelerDetails.setTravelerFirstName(travelerFirstName);
	}

	public void setTravelerLastName(String travelerLastName) {
		travelerDetails.setTravelerLastName(travelerLastName);
	}

	public void setTravelerSpecial(String travelerSpecial) {
		travelerDetails.setTravelerSpecial(travelerSpecial);
	}

	public String getTravelerFirstNameError() {
		return travelerDetails.getTravelerFirstNameError();
	}

	public String getTravelerLastNameError() {
		return travelerDetails.getTravelerLastNameError();
	}

	public String getBookingPrice() {
		return orderDetails.getBookingPrice();
	}

	public boolean isContactInformationEmailInputPresent() {
		return contactInformationDetails.isContactInformationEmailInputPresent();
	}

	public boolean isContactInformationCountryCodeInputPresent() {
		return contactInformationDetails.isContactInformationCountryCodeInputPresent();
	}

	public boolean isContactInformationPhoneNumberPresent() {
		return contactInformationDetails.isContactInformationPhoneNumberPresent();
	}

	public void setContactInformationEmail(String contactInformationEmail) {
		contactInformationDetails.setContactInformationEmail(contactInformationEmail);
	}

	public void setContactInformationCountryCode(String contactInformationCountryCode) {
		contactInformationDetails.setContactInformationCountryCode(contactInformationCountryCode);
	}

	public void setContactInformationPhoneNumber(String contactInformationPhoneNumber) {
		contactInformationDetails.setContactInformationPhoneNumber(contactInformationPhoneNumber);
	}

	public String getContactEmailError() {
		return contactInformationDetails.getContactEmailError();
	}

	public String getContactPhoneNumberError() {
		return contactInformationDetails.getContactPhoneNumberError();
	}

	public boolean isBookNowButtonPresent() {
		return $(locators.buttonBookNow()).exists();
	}

	public void ccBook() {
		$(locators.buttonBookNow()).click();
	}

	public boolean isButtonGooglePayPresent(){
		return $(locators.buttonGooglePay()).exists();
	}

	public boolean isButtonApplePayPresent(){
		return $(locators.buttonApplePay()).exists();
	}

	public boolean isButtonPaypalPayPresent(){
		WebElement elem =  getWebDriver().findElement(By.xpath("//iframe[@class='xcomponent-component-frame xcomponent-visible']"));
		switchTo().frame(elem);
		$$(locators.buttonPaypalPay()).shouldBe(CollectionCondition.sizeGreaterThan(0)).findBy(Condition.visible);
		switchTo().defaultContent();
		return true;
	}

	public boolean expDateMonthHasError() {
		return paymentDetails.expDateMonthHasError();
	}

	public boolean expDateYearHasError() {
		return paymentDetails.expDateYearHasError();
	}

	public String getBookingProduct() {
		return orderDetails.getBookingProduct();
	}

	public String getBookingDate() {
		return orderDetails.getBookingDate();
	}

	public String getBookingService() {
		return orderDetails.getBookingService();
	}
}