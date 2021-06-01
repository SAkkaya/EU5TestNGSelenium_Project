package com.cybertek.tests.day2_webdreiver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //Task open chrome and navigate to http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.google.com");  // get ve navigate ikii de ayni sey
        driver.navigate().to("http://practice.cybertekschool.com");

        //getting title with selenium
        //shortcut for creating variable
        //Option or ALT +enter enter
        //getTitle()--> get you the titel of page
        String title = driver.getTitle(); //option+ENTER ==> variable name

        //soutv + enter to  print variable name and value
        System.out.println("title = " + title);

        //getCurrentUrl --> get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() --> get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }


}
