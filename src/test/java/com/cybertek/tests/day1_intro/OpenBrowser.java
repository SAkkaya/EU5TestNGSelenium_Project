package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class OpenBrowser {

    public static void main(String[] args) {

//        //we have to enter this line every time we want to open chrome
//        //hey WebDriverManager, can you make chrome ready for me for automation
//
//        WebDriverManager.chromedriver().setup();
//
//        //WebDiver represent the browser
//        //we are creating driver for chrome browser
//        //new ChromeDriver() --> this part will open chrome browser
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://cybertekschool.com");

            WebDriverManager.firefoxdriver().setup();
            WebDriver driver =  new FirefoxDriver();
           // FirefoxDriver driver =  new FirefoxDriver();
            driver.get("https://www.facebook.com");

//            WebDriver sdriver=new SafariDriver();
//            sdriver.get("https://www.google.com");






    }

}
