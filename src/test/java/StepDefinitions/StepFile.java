package StepDefinitions;

import Application.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepFile {
    Test app;

    @Given("^User have opened the browser$")
    public  void openBrowser() {
        app=new Test();
        app.openBrowser();
    }

    @When("^User opens the website$")
    public void goToSauce(){app.goToSauce();}

    @And("^User enters valid username (.*) and password (.*)$")
    public void enterCredential(String userName,String password) {
        app.enterCredential(userName, password);
    }

    @And("^User clicks the login button$")
    public void clickLoginButton() {
        app.clickLoginButton();
    }

    @Then("^User should navigate to dashboard$")
    public void dashboardOpen() {
     app.dashboardOpen();
    }

    @And("^User enters valid username (.*) and wrong password (.*)$")
    public void enterInvalidCredential(String email, String password) {
        app.enterCredential(email, password);
    }

    @And("^User enters empty username and empty password$")
    public void enterEmptyCredential() {
        app.enterEmptyCredential();
    }

    @And("^User enters valid username (.*) and empty password$")
    public void enterValidEmailEmptyPassword(String email) {
        app.enterValidEmailEmptyPassword(email);
    }

    @And("^User enters empty username and valid password (.*)$")
    public void enterEmptyEmailValidPassword(String password) {
        app.enterEmptyEmailValidPassword(password);
    }

    @Then("^User should see an error message")
    public void seeError() {app.viewError();}


    @When("^User adds item with name (.*) to the cart$")
    public void addToCart(String itemName) {
        app.addToCart(itemName);
    }

    @Then("^User should see the item in the cart$")
    public void verifyItemInCart() {
        app.isItemInCart();
    }



}
