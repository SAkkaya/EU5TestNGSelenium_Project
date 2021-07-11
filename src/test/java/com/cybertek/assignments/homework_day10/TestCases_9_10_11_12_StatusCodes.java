package com.cybertek.assignments.homework_day10;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases_9_10_11_12_StatusCodes {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       driver.quit();
    }

    @Test
    public void test8() throws InterruptedException {

//      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//      Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Status Codes")).click();

//      Step 3. Then click on “200”, 301. 404, 500
//      Step 4. Verify that following message is displayed:“This page returned a 200 status code”
        for (int i = 1; i <= 4; i++) {

        driver.findElement(By.xpath("(//div[@class='example']//ul/li/a)["+i+"]")).click();
        WebElement message = driver.findElement(By.xpath("//div[@class='example']/p"));
        System.out.println("message.getText() = " + message.getText());
        Assert.assertTrue(message.isDisplayed(), "Verify that following message is displayed: " + message.getText());
        driver.navigate().back();

        }

    }

}





