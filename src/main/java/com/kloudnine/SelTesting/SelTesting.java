package com.kloudnine.SelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Steven on 8/16/2015.
 * Sel Testing
 */
public class SelTesting {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        // define URL
        driver.get( "http://www.google.com" );


        // perform tests
        driver.findElement(By.name( "q" )).sendKeys( "Cheese" );
        driver.findElement(By.name( "q" )).submit();

        System.out.println( "Page title is: " + driver.getTitle());

        // Google's page is rendered dynamically with java
        // so wait for page to load (timeout after 10 seconds)
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese");
            }
        });

        System.out.println( "Page title is: " + driver.getTitle());

        // stop driver/close browser
        driver.quit();


    }

}
