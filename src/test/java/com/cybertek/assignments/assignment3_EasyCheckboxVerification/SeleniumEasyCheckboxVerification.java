package com.cybertek.assignments.assignment3_EasyCheckboxVerification;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumEasyCheckboxVerification {

    WebDriver driver;

    //Open Chrome browser
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        //Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //Verify “Success – Check box is checked” message is NOT displayed.
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='txtAge']"));
        Assert.assertFalse(checkbox.isDisplayed(),"Verify “Success – Check box is checked” message is NOT displayed");

    //Click to checkbox under “Single Checkbox Demo” section

        driver.findElement(By.cssSelector("input#isAgeSelected")).click();

    //Verify “Success – Check box is checked” message is displayed.

        Assert.assertEquals(checkbox.getText(),"Success - Check box is checked","Verify “Success – Check box is checked” message is displayed" );

    }

    @Test
    public void test2(){
//        1. Open Chrome browser
//        2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

//        3. Verify “Check All” button text is “Check All”
            WebElement checkAll=driver.findElement(By.cssSelector("input#check1"));

            String checkAllValue= checkAll.getAttribute("value");
            Assert.assertEquals(checkAllValue,"Check All","Check All” button text is “Check All" );

//        4. Click to “Check All” button
            checkAll.click();

//        5. Verify all check boxes are checked

        List<WebElement> checkBoxElements = driver.findElements(By.className("cb1-element"));

        for (WebElement checkBoxElement : checkBoxElements) {
            Assert.assertTrue(checkBoxElement.isSelected(), "Verify all check boxes are checked");
        }

//        6. Verify button text changed to “Uncheck All”

        Assert.assertEquals(checkAll.getAttribute("value"),"Uncheck All","Verify button text changed to “Uncheck All" );


    }



}
