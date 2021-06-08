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
        driver.get("https://www.amazon.com/");
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //driver.manage().window().maximize();

        searchBox.sendKeys("Selenium");

        //click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();
//            driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
//            driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/input);

        WebElement result =  driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String resultText=result.getText();
        System.out.println("resultText = " + resultText);

        String expectedResult= "1-48 of 185 results for";

        if (expectedResult.equals(resultText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedText = " + expectedResult);
            System.out.println("resultText = " + resultText);
        }
        Thread.sleep(2000);
        driver.quit();


    }


}
