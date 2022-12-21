package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

 /*
    public static WebElement waitForPresenceOfElementLocatedBy (WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofMillis(8000))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElementToBeClickable (WebDriver driver, WebElement webElement){
        return new WebDriverWait(driver, Duration.ofMillis(8000))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }*/
    public static WebElement waitForPresenceOfElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement){
        return new WebDriverWait(driver, Duration.ofMillis(8000))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}



