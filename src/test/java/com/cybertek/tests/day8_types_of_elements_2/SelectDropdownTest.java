package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectDropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);//*****daha erken gecerse 6 saniyenin tamamini beklemeyecek********
                                                                                        //implicitly wait methodu eger kod hata veriyorsa 6 sn( TimeUnit Long)  bekliyor sonra hata veriyor.
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like any other webelement with unique locator  // MAke sure that tagName of DropDown is "select"
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);  //Select ==>class name from Selenium; stateDropdown==> ObjectNAme;  WebElement=>dropdownElement

        //getOptions--> returns all the available options from dropdown
        List<WebElement> options = stateDropdown.getOptions();
        //print size of the options
        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator  // MAke sure that tagName of DropDown is "select"
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);  //Select ==>class name from Selenium; stateDropdown==> ObjectNAme;  WebElement=>dropdownElement

        //verify that first selection is Select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN?
        //1. SELECT USING VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption="Virginia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection"); //artik Virginia secildigi icin ilk element o

        //2.SELECT USING INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51); //Java oldugu icin sleep() java da ilk index no: 0 dan baslar

        expectedOption="Wyoming";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //3.SELECT USING VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption="Texas";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

    }


}
