package com.cybertek.tests.day2_webdreiver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");    //WebDriverFactory==> Utility class

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);


    }


}
