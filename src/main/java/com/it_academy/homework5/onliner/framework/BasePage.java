package com.it_academy.homework5.onliner.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.it_academy.homework5.onliner.framework.DriverManager.getDriver;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public abstract class BasePage {

    private static final Duration DRIVER_WAIT_TIME = ofSeconds(20);

    public BasePage(){
        DriverManager.setDriver();
        PageFactory.initElements(getDriver(), this);
    }

    public void navigate(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public WebElement waitForElementVisible(By by) {
        return new WebDriverWait(getDriver(), DRIVER_WAIT_TIME)
                .until(visibilityOfElementLocated(by));
    }

    public List<WebElement> waitForElementsVisible(List<WebElement> webElements) {
        return new WebDriverWait(getDriver(), DRIVER_WAIT_TIME)
                .until(visibilityOfAllElements(webElements));
    }

    public List<WebElement> waitForElementsVisible(By by) {
        return new WebDriverWait(getDriver(), DRIVER_WAIT_TIME)
                .until(visibilityOfAllElementsLocatedBy(by));
    }
}
