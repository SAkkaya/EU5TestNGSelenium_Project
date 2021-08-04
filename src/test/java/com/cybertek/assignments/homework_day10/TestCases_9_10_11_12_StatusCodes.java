package com.cybertek.assignments.homework_day10;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
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

    @DataProvider
    Object[][] testData() {

        String[][] expectedData = {
                {"200", "This page returned a 200 status code"},
                {"301", "This page returned a 301 status code"},
                {"404", "This page returned a 404 status code"},
                {"500", "This page returned a 500 status code"},

        };

        return expectedData;
    }

    @Test(dataProvider = "testData")
    public void test1(String statusCodes, String expectedTextMessage) {
//      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//      Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Status Codes")).click();
//      Step 3. Then click on “200”, 301. 404, 500
        String locator = "//a[contains(text(), '" + statusCodes + "')]";
        driver.findElement(By.xpath(locator)).click();

        String actualBeforeSubstring= driver.findElement((By.xpath("//p"))).getText();
        String actualTextMessage = actualBeforeSubstring.substring(0, actualBeforeSubstring.indexOf("."));
        System.out.println("actualTextMessage = " + actualTextMessage);

//      Step 4. VerifyContactInformationTest that following message is displayed:“This page returned a 200 status code”
        System.out.println("Status Codes = " + statusCodes + " expectedTextMessage : " + expectedTextMessage);

        Assert.assertEquals(actualTextMessage, expectedTextMessage, "Verify that following message is displayed:“This page returned a "+ statusCodes + " status code");


    }

}








