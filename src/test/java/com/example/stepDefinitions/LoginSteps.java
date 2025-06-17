package com.example.stepDefinitions;

import com.example.pages.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @And("user clicks the login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user should be redirected to the inventory page")
    public void user_should_see_inventory_page() {
        assertTrue(loginPage.isLoginSuccess());
        driver.quit();
    }
}