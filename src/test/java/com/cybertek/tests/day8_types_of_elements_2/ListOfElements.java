package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size()); //buttons.size() = 6

        //"verify button size    ****** verify size number is ve ry important to get the test successfully pass
        Assert.assertEquals(buttons.size(), 6, "verify button size ");


        for (WebElement button : buttons) {
            // System.out.println(button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(), "verify buttons are displayed");
        }

        //click second button
        buttons.get(1).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //regular find Element method will throw NSE idf loctor does not exist
       // driver.findElement(By.tagName("buttonsajjaajjäaas"));
        //no such element: Unable to locate element: {"method":"css selector","selector":"buttonsajjaajjäaas"}

        //passing locator which does not exist, it will not throw NoSuchElement
        //ALT+Enter or OPTION+Enter then one more enter for the shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("buttonsajjaajjäaas"));
        //Total tests run: 1, Passes: 1, Failures: 0, Skips: 0  ==> test passes olur cunku boyle bir element olmadigi icin size=0 olur

        System.out.println("buttons.size() = " + buttons.size()); //buttons.size() = 0

    }





}
