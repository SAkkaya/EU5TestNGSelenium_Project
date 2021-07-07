package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriverWait wait;
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
       // wait = new WebDriverWait(driver, 10); // creating wait object from  WebDriverWait class

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

     //   Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
      //  driver.findElement(By.cssSelector("#start>button")).click();
        driver.findElement(By.tagName("button")).click(); //first button

        WebElement usernameInput = driver.findElement(By.id("username"));

        //HOW TO WAIT EXPLICITLY ?
        //create Explicit wait object

        WebDriverWait wait = new WebDriverWait(driver, 10); // constructor

        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("MikeSmith");
    }

    @Test

    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        //finding inbox Box
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("MikeSmith");

    }
}
