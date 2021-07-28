package com.cybertek.assignments.project_bedbathandbeyon;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ChartAndCheckOut {

    WebDriver driver;

    @Test
    public void testMixer(){
//        1. Go to https://www.bedbathandbeyond.com/
        driver= WebDriverFactory.getDriver("chrome");
        driver.get(" https://www.bedbathandbeyond.com/");

//        2. Enter your item and click search
        driver.findElement(By.id("searchInput")).sendKeys("mixer");


//        3. Sort by rating and click most popular
//        4. Click first product
//        5. Adjust qty 2
//        6. Pick to color
//        7. Click add to chart
//        8. Click view cart & checkout
//        9. VerifyContactInformationTest popup page’s subtotal and check out’s subtotal should be same
    }



}
