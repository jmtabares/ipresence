package com.ipresence.steps;

import com.ipresence.framework.pages.CheckoutPage;
import com.ipresence.framework.pages.checkoutPageComponents.BaseSteps;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutSteps extends BaseSteps {
	CheckoutPage checkoutPage = new CheckoutPage();
	TestContext testContext;

	public CheckoutSteps(TestContext context) {
		super(context);
		testContext = context;
	}

	@Then("I verify the price")
	public void iVerifyThePrice() {
		checkoutPage.waitForPageToLoad();
		String price = (String) testContext.scenarioContext.getContext(Context.EXPERIENCE_PRICE);
		Assert.assertTrue(checkoutPage.getBookingPrice().equalsIgnoreCase(price));
	}

	@Then("I verify the product")
	public void iVerifyTheProduct() {
		checkoutPage.waitForPageToLoad();
		String product = (String) testContext.scenarioContext.getContext(Context.EXPERIENCE_PRODUCT);
		Assert.assertTrue(checkoutPage.getBookingProduct().equalsIgnoreCase(product));
	}

	@Then("I verify the date")
	public void iVerifyTheDate() {
		checkoutPage.waitForPageToLoad();
		String date = (String) testContext.scenarioContext.getContext(Context.EXPERIENCE_DATE);
		String actual = checkoutPage.getBookingDate();
		if (actual.matches("[A-Za-z]*\\s0\\d.*")) {
			actual = actual.replaceFirst("0", "");		}
		Assert.assertTrue(date.contains(actual));
	}

	@Then("I verify the service")
	public void iVerifyTheService() {
		checkoutPage.waitForPageToLoad();
		String service = (String) testContext.scenarioContext.getContext(Context.EXPERIENCE_SERVICE);
		Assert.assertTrue(checkoutPage.getBookingService().contains(service));
	}

	@Then("I verify Book Now button for credit Card payment")
	public void iVerifyBookNowButtonForCreditCardPayment() {
		checkoutPage.selectCCPaymentMethod();
		Assert.assertTrue(checkoutPage.isBookNowButtonPresent());
	}

	private void bookWithCC() {
		checkoutPage.selectCCPaymentMethod();
		checkoutPage.ccBook();
	}

	private void simpleTextAssert(String field, String actual, String expected) {
		String errMsg = String.format("Expected value for field [%s] to be [%s] but got [%s]", field, expected, actual);
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	private void setCCData(String fullName, String number, String ccv, String month, String year) {
		checkoutPage.setCardholderNameInput(fullName);
		checkoutPage.setCreditCardNumber(number);
		checkoutPage.setCreditCardSecCode(ccv);
		if (!month.isEmpty()) checkoutPage.setExpirationDateMonth(month);
		if (!year.isEmpty()) checkoutPage.setExpirationDateYear(year);
	}

	private void setTravelerDetails(String travelerFirstName, String travelerLastName, String travelerSpecial) {
		checkoutPage.setTravelerFirstName(travelerFirstName);
		checkoutPage.setTravelerLastName(travelerLastName);
		checkoutPage.setTravelerSpecial(travelerSpecial);
	}

	private void setTravelerContactInformation(String email, String phoneNumber) {
		checkoutPage.setContactInformationEmail(email);
		checkoutPage.setContactInformationPhoneNumber(phoneNumber);
	}

	@Then("I verify CVV Number is required")
	public void iVerifyCVVNumberIsRequired() {
		setTravelerDetails("Test", "Dummy", "");
		setTravelerContactInformation("dummy@test.com", "666666666");
		setCCData("Dummy Test", "5555555555554444", "", "12", "2039");
		bookWithCC();
		simpleTextAssert("CCV Error", checkoutPage.getSecurityCodeError(), messages.securityCodeError());
	}

	@Then("I verify with Invalid Expiry Date")
	public void iVerifyWithValidCardNumberInvalidExpiryDateValidCVVNumber() {
		setTravelerDetails("Test", "Dummy", "");
		setTravelerContactInformation("dummy@test.com", "666666666");
		setCCData("Dummy Test", "5555555555554444", "123", "", "");
		bookWithCC();
		Assert.assertTrue(checkoutPage.expDateMonthHasError());
		Assert.assertTrue(checkoutPage.expDateYearHasError());
	}

	@Then("I verify with Invalid Card Number")
	public void iVerifyWithInvalidCardNumberValidExpiryDateValidCVVNumber() {
		setTravelerDetails("Test", "Dummy", "");
		setTravelerContactInformation("dummy@test.com", "666666666");
		setCCData("Dummy Test", "1234567890123456788", "999", "12", "2039");
		bookWithCC();
		simpleTextAssert("Invalid Card Number Error", checkoutPage.getCreditCardError(), messages.creditCardError());
	}

	@Then("I verify traveler data first name is required")
	public void iVerifyTravelerDataFirstNameIsRequired() {
		bookWithCC();
		setTravelerDetails("", "Dummy", "");
		setTravelerContactInformation("dummy@test.com", "666666666");
		setCCData("Dummy Test", "5555555555554444", "999", "12", "2039");
		simpleTextAssert("traveler data first name error", checkoutPage.getTravelerFirstNameError(), messages.firstNameRequiredError());
	}

	@Then("I verify traveler data last name is required")
	public void iVerifyTravelerDataLastNameIsRequired() {
		setTravelerDetails("Test", "", "");
		setTravelerContactInformation("dummy@test.com", "666666666");
		setCCData("Dummy Test", "5555555555554444", "999", "12", "2039");
		bookWithCC();
		simpleTextAssert("traveler data last name error", checkoutPage.getTravelerLastNameError(), messages.lastNameRequiredError());
	}

	@Then("I verify card holder data full name is required")
	public void iVerifyCardHolderDataFullNameIsRequired() {
		setTravelerDetails("Test", "Dummy", "");
		setTravelerContactInformation("dummy@test.com", "666666666");
		setCCData("", "5555555555554444", "999", "12", "2039");
		bookWithCC();
		simpleTextAssert("card holder data full name error", checkoutPage.getCreditCardFullNameError(), messages.fullNameRequiredError());
	}

	@Then("I verify with Paypal button for Paypal payment")
	public void iVerifyWithPaypalButtonForPaypalPayment() {
		checkoutPage.selectPPPaymentMethod();
		Assert.assertTrue("Expected Paypal payment button to be present but is not", checkoutPage.isButtonPaypalPayPresent());
	}

	@Then("I verify contact information email is required")
	public void iVerifyContactInformationEmailIsRequired() {
		setTravelerDetails("Test", "Dummy", "");
		setTravelerContactInformation("", "666666666");
		setCCData("Dummy Test", "5555555555554444", "999", "12", "2039");
		bookWithCC();
		simpleTextAssert("contact information email error", checkoutPage.getContactEmailError(), messages.contactInfoEmailError());
	}

	@Then("I verify contact information phone number is required")
	public void iVerifyContactInformationPhoneNumberIsRequired() {
		setTravelerDetails("Test", "Dummy", "");
		setTravelerContactInformation("dummy@test.com", "");
		setCCData("Dummy Test", "5555555555554444", "999", "12", "2039");
		bookWithCC();
		simpleTextAssert("contact information phone number error", checkoutPage.getContactPhoneNumberError(), messages.contactInfoPhoneError());
	}
}
