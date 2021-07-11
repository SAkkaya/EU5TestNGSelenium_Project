package com.cybertek.assignments.HW_day10_HoverOver;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverOver {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }

    @Test
    public void test() throws InterruptedException {


        for (int i = 1; i <= 3; i++) {
            driver.get("http://practice.cybertekschool.com/hovers");
            String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            WebElement view_profile_element = driver.findElement(By.linkText("View profile"));

            System.out.println("view_profile_element "+ i + " = " + view_profile_element.getText());
            Assert.assertTrue(view_profile_element.isDisplayed(),"verify user "+i+" is displayed");


        }


    }


}
