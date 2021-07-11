package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void SwitchWindowsTest() throws InterruptedException {       // 2 window acik ise sadece

        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("Title before new window:"+driver.getTitle());  //Practice

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Title after new window:"+driver.getTitle()); //Practice

       // System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
                                            // returns a unique code for current window
        System.out.println(driver.getWindowHandle());  //hashSet windowlar icin ayrilmis ozel id numarasi veriyor
                                                            //CDwindow-6CE8885BBA8FB4738A36921B51E06338
        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles(); // butun acik windowlari store ediyor


        for (String handle : windowHandles) {
//            System.out.println(driver.getWindowHandle());
//            driver.switchTo().window(handle);
            if(!handle.equals(currentWindowHandle)){    // eger current window um degilse digerine switch et
                driver.switchTo().window(handle);
            }
        }
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        //driver.getWindowHandle() = CDwindow-20B309034167FCCF195C5A999CF0504B

        System.out.println("Title after switch new window:"+driver.getTitle());

    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before Switch:"+driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();


        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle); // one by one switch ediyor

            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }

        }

        System.out.println("After Switch: "+driver.getTitle());

    }




}
