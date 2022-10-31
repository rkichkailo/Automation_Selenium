package com.it_academy.homework5.onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(){
        if(driver.get() == null){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void startDriver(){
        driver.get().manage().window().maximize();
    }

    public static void closeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
