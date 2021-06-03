package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLChanged {

    public static void main(String[] args) throws InterruptedException {

     /* Verify URL changed
        open chrome browser
        go to http://www.practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
    */

    //open chrome browser

    WebDriver driver = WebDriverFactory.getDriver("cHroMe");

        // go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

     //enter any email
       WebElement emailInputBox =  driver.findElement(By.name("email"));

       //sendKeys()-->send keyboard action
        emailInputBox.sendKeys("mike@smith.com");

        //  click on Retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //internet yavas ise test hata verebilir o yuzden sayfada 2 sna beklemesi icin Tread verebiliriz, yoksa gerek yok
        Thread.sleep(2000);  // sleep kirmizi olacak ilk,  hover over -> click Add exception method

        //TASK:
       // verify that url changed to http://practice.cybertekschool.com/email_sent
        //create expectedUrl
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        //saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");  // "FAIL".sout   -> ENTER --> System.out.println("FAIL");
            System.out.println(("expectedUrl = " + expectedUrl));
            System.out.println(("actualUrl = " + actualUrl));
        }

        // close your browser
        driver.quit();
    }
}
