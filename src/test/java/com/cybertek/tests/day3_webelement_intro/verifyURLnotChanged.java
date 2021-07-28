package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.sun.tools.javac.jvm.ByteCodes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyURLnotChanged {

    public static void main(String[] args) {
        /*VerifyContactInformationTest URL not changed
	    -open chrome browser
	    -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
	    -click on Retrieve password
	    -verify that url did not change
	    */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");


        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();  // butona basmadan once

        // click on Retrieve password
        //WebElement --> Interface that represent elements on the webpage
        // findElement --> method used to find element on a page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //WebElement retrievePasswordButton = new WebElement () ==> yapmiyoruz cunku  zaten var bu element onu buluyoruz yaratmiyoruz
        retrievePasswordButton.click();

        //save actual url after clicking button
        String actualUrl = driver.getCurrentUrl();


        // verify that url did not change

        if( expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        // close your browser
       driver.quit();

    }


}
