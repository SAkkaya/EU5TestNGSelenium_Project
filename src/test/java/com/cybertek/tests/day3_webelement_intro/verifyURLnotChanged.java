package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyURLnotChanged {

    public static void main(String[] args) {
        /*Verify URL not changed
	    -open chrome browser
	    -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
	    -click on Retrieve password
	    -verify that url did not change
	    */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //WebElement retrievePasswordButton = new WebElement () ==> yapmiyoruz cunku  zaten var bu element onu buluyoruz yaratmiyoruz
        retrievePasswordButton.click();

    }


}
