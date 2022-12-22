package test;

import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;


@Listeners({TestListener.class})
public class CommonCondition {
    protected WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\tyahl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }
/*
    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }*/
}
