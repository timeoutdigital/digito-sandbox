Feature: Ensure Time Out systems and services are functioning
  In order to make use of Time Out's global offering
  As a website user
  I need to rely on the systems and services that support the website

 Scenario: Ask for a city homepage
    When I ask to see the "/london" homepage
    Then the request should be successful