package com.cybertek.assignments.homework_day10;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase8_isMessageDisplaed {

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
    public void test8() {

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();

//        Step 3. Enter “United States of America” into country input box.

        driver.findElement(By.name("myCountry")).sendKeys("United States of America");

//        Step 4. Verify that following message is displayed:“You selected: United States of America”

        driver.findElement(By.cssSelector("[value='Submit']")).click();
        WebElement actualText = driver.findElement(By.cssSelector("#result"));
        System.out.println("actualText.getText() = " + actualText.getText());

        Assert.assertTrue(actualText.isDisplayed(), "Verify that following message is displayed: You selected: United States of America");

    }

}