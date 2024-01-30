@LoginPage
Feature: CucumberJava

    @ValidCredentials
    Scenario: Verify if the valid username and password is entered then user should navigate to the dashboard
        Given User have opened the browser
        When User opens the website
        And User enters valid username standard_user and password secret_sauce
        And User clicks the login button
        Then User should navigate to dashboard


    @InvalidCredentials
    Scenario: Verify that the user inputs valid email and wrong password (output should be error message)
        Given User have opened the browser
        When User opens the website
        And User enters valid username standard_user and wrong password invalid_password
        And User clicks the login button
        Then User should see an error message

    @EmptyCredentials
    Scenario: Verify that the user inputs empty email and empty password (output should be error message)
        Given User have opened the browser
        When User opens the website
        And User enters empty username and empty password
        And User clicks the login button
        Then User should see an error message

    @ValidEmailEmptyPassword
    Scenario: Verify that the user inputs valid email and empty password (output should be error message)
        Given User have opened the browser
        When User opens the website
        And User enters valid username standard_user and empty password
        And User clicks the login button
        Then User should see an error message

    @EmptyEmailValidPassword
    Scenario: Verify that the user inputs empty email and valid password (output should be error message)
        Given User have opened the browser
        When User opens the website
        And User enters empty username and valid password secret_sauce
        And User clicks the login button
        Then User should see an error message