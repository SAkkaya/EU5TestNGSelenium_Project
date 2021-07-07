package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PupupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the confirm button
        driver.findElement(By.xpath("//span[.='Confirm']/..")).click();
        //driver.findElement(By.xpath("//button/span[text()='Confirm']")).click(); //Jemalin

        //click NO button
        driver.findElement(By.xpath("//span[.='No']")).click();
       // driver.findElement(By.xpath("//button[.='No']")).click(); // //Jemalin

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click for JS Alert Button
        driver.findElement(By.xpath("//button[1]")).click();

        //SWITCH TO JS ALERT PUP UP

        Alert alert = driver.switchTo().alert(); //driver dan alert sayfasina gecen obje(alert)
        Thread.sleep(2000);
        alert.accept(); //ok

        // click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();  //cancel

        // click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);

        //send keys to JS Prompt
        alert.sendKeys("Mike Smith");

        System.out.println("alert.getText() = " + alert.getText());
        //alert.getText() = I am a JS prompt

        //click ok
        alert.accept();


    }

}
