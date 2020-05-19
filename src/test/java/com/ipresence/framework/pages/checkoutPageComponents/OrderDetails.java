package com.ipresence.framework.pages.checkoutPageComponents;

import com.codeborne.selenide.CollectionCondition;
import com.ipresence.framework.data.interfaces.CheckoutPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderDetails {
	CheckoutPageLocators locators;

	public OrderDetails(CheckoutPageLocators locators) {
		this.locators = locators;
	}

	public String getBookingPrice() {
		$$(locators.price()).shouldBe(CollectionCondition.sizeGreaterThan(0));
		return $$(locators.price()).last().getText();
	}

	public String getBookingProduct() {
		return $(locators.product()).getText();
	}

	public String getBookingDate() {
		String result = $$(locators.orderDetails()).get(0).getText();
		if (result == null) $$(locators.orderDetailsSmall()).get(0).getText();
		return result;
	}

	public String getBookingService() {
		String result = $$(locators.orderDetails()).get(1).getText();
		if (result == null) $$(locators.orderDetailsSmall()).get(1).getText();
		return result;
	}
}
