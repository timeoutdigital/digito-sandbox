Feature: Use the Time Out website
  In order to use the Time Out website
  As a website user
  I need to perform common activities

@javascript
Scenario: Ask for all the "Hub" pages in the top level navigation menu
   Given I am on the "london" homepage
    When I ask for each item in the top level navigation menu
    Then the request should be successful