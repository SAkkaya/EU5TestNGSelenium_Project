package com.cybertek.assignments.assignment1_Locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
       /*
        Go to wikipedia.org (Links to an external site.)
        enter search term `selenium webdriver'
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)'
        */

    public static void main(String[] args) {
        //Go to wikipedia.org (Links to an external site.)
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        //enter search term `selenium webdriver'
        WebElement searchBox= driver.findElement(By.xpath("//div/input"));
        searchBox.click();
        searchBox.sendKeys("selenium webdriver");

        //click on search button
        driver.findElement(By.xpath("//i[@data-jsl10n='search-input-button']")).click();

        //click on search result `Selenium (software)`
        driver.findElement(By.xpath("//ul/li[@class='mw-search-result'][1]/div/a")).click();

        //verify url ends with `Selenium_(software)'
        String urlActual= driver.getCurrentUrl();
        String urlExpected="Selenium_(software)";


        if(urlActual.endsWith(urlExpected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("urlActual = " + urlActual);
            System.out.println("urlExpected = " + urlExpected);
        }

        driver.quit();


    }

}
