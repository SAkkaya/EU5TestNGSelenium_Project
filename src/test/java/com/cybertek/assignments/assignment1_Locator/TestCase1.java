package com.cybertek.assignments.assignment1_Locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {

    public static void main(String[] args) {

    /*
        Go to Ebay
        enter search term
        click on search button
        print number of results

     */
    // Go to Ebay
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://www.ebay.de/");

    //enter search term
    WebElement searchBox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
    searchBox.click();
    searchBox.sendKeys("search");

    //click on search button
    driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

    // print number of results
       String results = driver.findElement(By.xpath("//h1/span[1]")).getText();

        System.out.println("number of results = " + results);

        driver.quit();

    }


}
