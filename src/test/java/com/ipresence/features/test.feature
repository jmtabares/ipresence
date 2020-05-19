Feature: test

  Background: : Navigate to the payment page
    Given I open browser
    And I search for city "Paris" on country "France"
    When I select any experience
    And I set the default pax number
    And I book now

  Scenario: Verify price is correct
    Then I verify the price

  Scenario: Verify Credit Card Payment
    Then I verify Book Now button for credit Card payment

  Scenario: Verify CVV Number is required
    Then I verify CVV Number is required

  Scenario: Invalid Expiry Date
    Then I verify with Invalid Expiry Date

  Scenario: Test with Invalid Card Number
    Then I verify with Invalid Card Number

  Scenario: Verify traveler data first name is required
    Then I verify traveler data first name is required

  Scenario: Verify traveler data last name is required
    Then I verify traveler data last name is required

  Scenario: Verify card holder data full name is required
    Then I verify card holder data full name is required

  Scenario: Verify Paypal
    Then I verify with Paypal button for Paypal payment

  Scenario: Verify contact information email is required
    Then I verify contact information email is required

  Scenario: Verify contact information phone number is required
    Then I verify contact information phone number is required

  Scenario: Verify the product is correct
    Then I verify the product
@wip
  Scenario: Verify the service is correct
    Then I verify the service

  Scenario: Verify the date is correct
    Then I verify the date