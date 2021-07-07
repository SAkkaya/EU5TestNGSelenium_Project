package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {

    public static void main(String[] args) {

       WebDriver driver = WebDriverFactory.getDriver("chrome");

//         WebDriverFactory w1= new WebDriverFactory();      // eger WebDriverFactory static olmasa idi class ismi yerine obje yaratip obje ismi
        //w1.getDriver("chrome");                                               //   ile cagircagiracktik

        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // print multiple buttons header

        System.out.println("multiple buttons header = "+ driver.findElement(By.className("h3")).getText()); //multiple buttons header = Multiple buttons
        //className oldugu gibi tagName e gore de olur;
        //System.out.println("multiple buttons header = " + driver.findElement(By.tagName("h3")).getText());


    }



}
