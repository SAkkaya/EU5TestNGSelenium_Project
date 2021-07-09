package com.cybertek.assignments.homework_day10;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestScripts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.quit();
    }

    @Test
    public void test1(){          // List<Element> ile bulmayi dene
//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();
//        Step 3. Enter “wrong_dob” into date of birth input box.
        WebElement dateOfBirth= driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("19/05/2013");
//        Step 4. Verify that warning message is displayed:“The date of birth is not valid”
        WebElement dobText=driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        Boolean dobIsDisplayed=dobText.isDisplayed();
        System.out.println("dobIsDisplayed = " + dobIsDisplayed);

        String actualDOBText = dobText.getText();
        System.out.println("actualDOBText = " + actualDOBText);

        String expectedText = "The date of birth is not valid";
        Assert.assertEquals(actualDOBText,expectedText,"Verify that warning message is matched");
        Assert.assertTrue(dobIsDisplayed,"Verify that warning message is displayed:“The date of birth is not valid”");
    }

    @Test
    public void test2() {

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

//        Step 3. Verify that following options for programming languages are displayed: c++, java,JavaScript

        List<WebElement> programmingLanguages = driver.findElements(By.className("form-check-label"));

        for (WebElement programmingLanguage : programmingLanguages) {
            Assert.assertTrue(programmingLanguage.isDisplayed(), "Verify that following options for programming languages are displayed: c++, java,JavaScript");
            System.out.println("programmingLanguage = " + programmingLanguage.getText());
        }
    }
        @Test
        public void test3(){

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
            driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. Click on “Registration Form”
            driver.findElement(By.linkText("Registration Form")).click();

//        Step 3. Enter only one alphabetic character into firstname input box.
          driver.findElement(By.name("firstname")).sendKeys("a");

//        Step 4. Verify that warning message is displayed:“first name must be more than 2 and less than 64 characters long”

            WebElement actualname = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[1]"));

            Assert.assertTrue(actualname.isDisplayed(), "Verify that warning message is displayed:");
            String actualText = actualname.getText();
            System.out.println("actualText = " + actualText);

        }


    @Test
    public void test4(){

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

//        Step 3. Enter only one alphabetic character into last name input box.
        driver.findElement(By.name("lastname")).sendKeys("a");

//        Step 4. Verify that warning message is displayed:“last name must be more than 2 and less than 64 characters long”

        WebElement actuallastName = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[2]"));

        Assert.assertTrue(actuallastName.isDisplayed(), "Verify that warning message is displayed:");
        String actuallastNameText = actuallastName.getText();
        System.out.println("actuallastNameText = " + actuallastNameText);

    }

    @Test
    public void test5(){

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

//        Step 3. Enter any valid first name.
       driver.findElement(By.name("firstname")).sendKeys("sadik");
//        Step 4. Enter any valid last name.
        driver.findElement(By.name("lastname")).sendKeys("kaya");
//        Step 5. Enter any valid user name and email.
        driver.findElement(By.name("username")).sendKeys("kaya1234");
        driver.findElement(By.name("email")).sendKeys("kaya@email.com");
//        Step 6. Enter any valid password.
        driver.findElement(By.name("password")).sendKeys("kaya1234");
//        Step 7. Enter any valid phone number.
        driver.findElement(By.name("phone")).sendKeys("582-555-5000");
//        Step 8. Select gender.

//        Step 9. Enter any valid date of birth.
//        Step 10. Select any department.
//        Step 11. Enter any job title.
//        Step 12. Select java as a programming language.
//        Step 13. Click Sign up.
//        Step 14. Verify that following success message is displayed: “You've successfully completed registration!”


    }








}
