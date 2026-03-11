package com.automation.pages;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(css = "a[href='/products']")
    public WebElement productsButton;

    @FindBy(css = "a[href='/view_cart']")
    public WebElement cartButton;

    @FindBy(id = "slider-carousel")
    public WebElement homePageBanner;





    public void clickSignupLogin() {
        signupLoginButton.click();
    }

    public void clickProducts() {
        productsButton.click();
    }

    public void clickCart() {
        cartButton.click();
    }

    public boolean isHomePageBannerDisplayed() {
        return homePageBanner.isDisplayed();
    }


}
