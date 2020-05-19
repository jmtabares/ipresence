package com.ipresence.framework.data.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources({
		"classpath:${env}/pages/checkoutPageLocators.properties"
})
public interface CheckoutPageLocators extends Config {
	String travelDetailsFirstName();

	String travelDetailsLastName();

	String travelDetailsSpecial();

	String paymentPayPal();

	String paymentCreditCard();

	String paymentApplePay();

	String paymentGooglePay();

	String paymentCreditCardCardHolderName();

	String paymentCreditCardNumber();

	String paymentCreditCardExpMonth();

	String paymentCreditCardExpYear();

	String paymentCreditCardSecCode();

	String paymentCreditCardCountry();

	String contactInformationEmail();

	String contactInformationPhoneCountryCode();

	String contactInformationPhoneNumber();

	String buttonBookNow();

	String buttonGooglePay();

	String buttonApplePay();

	String buttonPaypalPay();

	String creditCardError();

	String securityCodeError();

	String paymentFullNameError();

	String travelerFirstNameError();

	String travelerLastNameError();

	String contactEmailError();

	String contactPhoneNumberError();

	String price();

	String product();

	String orderDetails();

	String paymentCreditCardIframe();

	String orderDetailsSmall();
}
