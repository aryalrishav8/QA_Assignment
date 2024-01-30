package Application;


import java.time.Duration;
import  PageObject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.closeWindow;

public class Test {
    public LoginPage loginPage;

    public void openBrowser() {
//        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
         WebDriver driver= new ChromeDriver(chromeOptions);
        loginPage = new LoginPage();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        WebDriverRunner.setWebDriver(driver);
    }

    public void goToSauce() {
        System.out.println("Redirected! ");
    }

    public void enterCredential(String userName, String password) {
        loginPage.enterUserName().should(Condition.appear,Duration.ofSeconds(30)).sendKeys(userName);
        loginPage.enterPassword().sendKeys(password);
    }

    public void clickLoginButton() {
        loginPage.loginButton().should(Condition.appear, Duration.ofSeconds(5)).click();
    }

    public void dashboardOpen() {
        loginPage.goToDashboard().isDisplayed();
    }

    public static void closeBrowser() {
        closeWindow();
    }

    public void enterEmptyCredential() {
        loginPage.enterUserName().should(Condition.appear, Duration.ofSeconds(30)).sendKeys("");
        loginPage.enterPassword().sendKeys("");
    }

    public void enterValidEmailEmptyPassword(String email) {
        loginPage.enterUserName().should(Condition.appear, Duration.ofSeconds(30)).sendKeys(email);
        loginPage.enterPassword().sendKeys("");
    }

    public void enterEmptyEmailValidPassword(String password) {
        loginPage.enterUserName().should(Condition.appear, Duration.ofSeconds(30)).sendKeys("");
        loginPage.enterPassword().sendKeys(password);
    }

    public void viewError() {
        loginPage.seeError().isDisplayed();
    }

    public void addToCart(String itemName) {

        SelenideElement item = $x("//div[@class='inventory_item']");
        item.$("btn btn_primary btn_small btn_inventory").click();
    }


    public void isItemInCart() {
        open("https://www.saucedemo.com/cart.html");

        String itemId = "";
         $("#item_4_title_link" + itemId).isDisplayed();
    }
}
