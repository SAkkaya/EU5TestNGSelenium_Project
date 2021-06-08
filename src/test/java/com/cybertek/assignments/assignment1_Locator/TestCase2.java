package com.cybertek.assignments.assignment1_Locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {
        /*Go to Ebay
        search Selenium
        click on search button
        verify title contains Selenium */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        //enter Selenium term
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.click();
        String searchItem="Selenium";
        searchBox.sendKeys(searchItem);

        //click on search button
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        //verify title contains Selenium
        String title = driver.getTitle();

        if (title.contains(searchItem)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("title = " + title);
            System.out.println("searchItem = " + searchItem);
        }

        driver.quit();



    }


}
