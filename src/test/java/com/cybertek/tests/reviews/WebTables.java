package com.cybertek.tests.reviews;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    WebDriver driver;
    String email;

    @BeforeMethod
    public void SetUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void test1(){
        WebElement nameElement = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+getName(email)+"']/../td[1]"));
        String name =nameElement.getText();
        System.out.println("name = " + name);

        List<WebElement> nameslist = driver.findElements(By.xpath("//table[@id='table1']/tbody//td[1]"));

        for (WebElement eachName : nameslist) {
            System.out.println( eachName.getText());
        }

    }

    public String getName(String name){
        String email = driver.findElement(By.xpath("//table[@id='table1']//td[3]")).getText();
        return email;
    }


}
