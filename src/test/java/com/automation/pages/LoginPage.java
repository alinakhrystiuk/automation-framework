package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Login
    @FindBy(xpath = "//div[@class='login-form']//input[@data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//div[@class='login-form']//input[@data-qa='login-password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    // Signup
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signupButton;

    // Error message
    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect')]")
    public WebElement incorrectLoginMessage;






    public void login(String email, String password) {
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        loginButton.click();
    }

    public void enterSignupDetails(String name, String email) {
        signupName.sendKeys(name);
        signupEmail.sendKeys(email);
        signupButton.click();
    }

    public boolean isIncorrectLoginMessageDisplayed() {
        return incorrectLoginMessage.isDisplayed();
    }
}
