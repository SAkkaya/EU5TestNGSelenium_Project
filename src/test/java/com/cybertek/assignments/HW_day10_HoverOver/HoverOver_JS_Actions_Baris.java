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

public class HoverOver_JS_Actions_Baris {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");
        for (int i = 1; i <=3 ; i++) {
            WebElement img = driver.findElement(By.xpath("(//img)["+i+"]"));
            Actions actions=new Actions(driver);
            //perform() --perform the action
            //moveToElement() hover the element
            actions.moveToElement(img).perform();

            WebElement view_profile_element = driver.findElement(By.linkText("View profile"));

            Assert.assertTrue(view_profile_element.isDisplayed(),"verifying displayed");


        }

    }
}