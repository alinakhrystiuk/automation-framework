package com.automation.step_definitions;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Before
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After
    public void teardown() {
        Driver.closeDriver();
    }

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("automationexercise.com"));
    }

    @When("user clicks on Signup Login button")
    public void user_clicks_on_signup_login_button() {
        homePage.clickSignupLogin();
    }

    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {
        loginPage.login(
                ConfigurationReader.getProperty("email"),
                ConfigurationReader.getProperty("password")
        );
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        // вже виконано у методі login()
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(
                Driver.getDriver().findElement(
                        org.openqa.selenium.By.cssSelector("a[href='/logout']")
                ).isDisplayed()
        );
    }



    @When("user enters invalid email and password")
    public void user_enters_invalid_email_and_password() {
        loginPage.login("invalid@test.com", "wrongpassword");
    }

    @Then("user should see incorrect login message")
    public void user_should_see_incorrect_login_message() {
        Assert.assertTrue(loginPage.isIncorrectLoginMessageDisplayed());
    }
}
