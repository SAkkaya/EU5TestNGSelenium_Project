package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /**
     * TASK
     * go to amazon.com
     * search for java
     * click search button
     * verify "1-16 von mehr als 30.000 Ergebnissen oder Vorschlägen für"
     *
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.de/?language=de_DE");
        driver.manage().window().maximize();
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.click();
        searchBox.sendKeys("Java");
        driver.findElement(By.xpath("//input[@value='Los']")).click();
        // WebElement selenium =  driver.findElement(By.xpath("//h1/div/div/div/div/span[1]"));
        WebElement javaSearchResult =  driver.findElement(By.xpath("//span[contains(text(),'Vorschlägen für')]"));

        String actualResult=javaSearchResult.getText();
        System.out.println("actualText = " + actualResult);
        String expectedResult= "1-16 von mehr als 30.000 Ergebnissen oder Vorschlägen für";

        if (actualResult.equals(expectedResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedText = " + expectedResult);
            System.out.println("actualText = " + actualResult);
        }
        Thread.sleep(2000);
        driver.quit();


    }


}
