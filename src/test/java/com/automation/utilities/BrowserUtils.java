package com.automation.utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class BrowserUtils {



    public static void waitForClickability(WebElement element, int seconds) {
    WebDriverWait wait = new WebDriverWait(
            Driver.getDriver(),
            Duration.ofSeconds(seconds)
    );
    wait.until(ExpectedConditions.elementToBeClickable(element));
}


    public static void waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(
                Driver.getDriver(),
                Duration.ofSeconds(seconds)
        );
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
