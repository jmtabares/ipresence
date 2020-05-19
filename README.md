# iPresence Challenge

## Stack
+ Java JDK 1.8 
+ Selenide
+ Maven
+ Junit 
+ Cucumber

### Folder Structure 
    Challenge
    |_scr
    |__test
    |___java
    |____com.ipresence
    |_____com.ipresence.framework
    |______com.ipresence.framework.data.interfaces
    |______com.ipresence.framework.listener
    |______com.ipresence.framework.pages
    |______com.ipresence.framework.checkoutPageComponents
    |______com.ipresence.framework.utilities
    |____resources

#### Folder contents
**Features**: feature files with test cases with gherkin stile
**Pages**: Classes that implement Page Object Model 
**Data/Interfaces**: interfaces used for the srtategy of conver the locators into properties  
**Steps**: Classes thta represents the glue between Gherkin and the java code
**Utilities**: Common code without bussiness meaning 
**Resources**: Configuration files

    
####  Run Test 
     + Run with tags     
         mvn -Dtest.environment=<ENV> -Dcucumber.options="<TAGS>"  clean test
         Example: mvn clean test -Dtest.environment=local -Dcucumber.options="-t @Run -t ~@WIP"
     + Run all test 
         mvn clean test -Dtest.environment=<ENV>      
         Example: mvn clean test -Dtest.environment= test
     + Run on grid     
        mvn clean test -Dtest.environment= test -Dselenide.remote=http://<ip>:<port>/wd/hub
        where <ip> stands for the ip number of your grid and <port> for the port number
        Example: mvn clean test -Dtest.environment=test -Dselenide.remote=http://localhost:4444/wd/hub
     + Run forcing webdriver version if you are unable to update chrome
         add  "-Dwdm.chromeDriverVersion=<Driver_version>"
         where <Driver_version> is the best suiteable driver version for your Chrome instance 
              https://chromedriver.chromium.org/downloads
     + Headless run   
        add -Dselenide.headless=true to command line

      
#### Test cases
  
     Background: : Navigate to the payment page
       Given I open browser
       And I search for city "Paris" on country "France"
       When I select any experience
       And I set the default pax number
       And I book now
   
     Scenario: Verify price is correct
         Given I open browser
         And I search for city "Paris" on country "France"
         When I select any experience
         And I set the default pax number
         And I book now  
         Then I verify the price
   
     Scenario: Verify Credit Card Payment
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now       
        Then I verify Book Now button for credit Card payment
   
     Scenario: Verify CVV Number is required
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify CVV Number is required
   
     Scenario: Invalid Expiry Date
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify with Invalid Expiry Date
   
     Scenario: Test with Invalid Card Number
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify with Invalid Card Number
   
     Scenario: Verify traveler data first name is required
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify traveler data first name is required
   
     Scenario: Verify traveler data last name is required
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify traveler data last name is required
   
     Scenario: Verify card holder data full name is required
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify card holder data full name is required
   
     Scenario: Verify Paypal
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify with Paypal button for Paypal payment
   
     Scenario: Verify contact information email is required
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify contact information email is required
   
     Scenario: Verify contact information phone number is required
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify contact information phone number is required
        
     Scenario: Verify the product is correct
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify contact information phone number is required
        Then I verify the product

      Scenario: Verify the service is correct
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify contact information phone number is required
        Then I verify the service

      Scenario: Verify the date is correct
        Given I open browser
        And I search for city "Paris" on country "France"
        When I select any experience
        And I set the default pax number
        And I book now  
        Then I verify contact information phone number is required
        Then I verify the date