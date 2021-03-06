package com.cybertek.assignments.homework_day10;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases_1_2_3_4_5_RegistrationFrom {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
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
//        Step 4. VerifyContactInformationTest that warning message is displayed:“The date of birth is not valid”
        WebElement dobText=driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        Boolean dobIsDisplayed=dobText.isDisplayed();
        System.out.println("dobIsDisplayed = " + dobIsDisplayed);

        String actualDOBText = dobText.getText();
        System.out.println("actualDOBText = " + actualDOBText);

        String expectedText = "The date of birth is not valid";
        Assert.assertEquals(actualDOBText,expectedText,"VerifyContactInformationTest that warning message is matched");
        Assert.assertTrue(dobIsDisplayed,"VerifyContactInformationTest that warning message is displayed:“The date of birth is not valid”");
    }

    @Test
    public void test2() {

//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
//        Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();

//        Step 3. VerifyContactInformationTest that following options for programming languages are displayed: c++, java,JavaScript

        List<WebElement> programmingLanguages = driver.findElements(By.className("form-check-label"));

        for (WebElement programmingLanguage : programmingLanguages) {
            Assert.assertTrue(programmingLanguage.isDisplayed(), "VerifyContactInformationTest that following options for programming languages are displayed");
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

//        Step 4. VerifyContactInformationTest that warning message is displayed:“first name must be more than 2 and less than 64 characters long”

            WebElement actualname = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[1]"));

            Assert.assertTrue(actualname.isDisplayed(), "VerifyContactInformationTest that warning message is displayed:");
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

//        Step 4. VerifyContactInformationTest that warning message is displayed:“last name must be more than 2 and less than 64 characters long”

        WebElement actuallastName = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[2]"));

        Assert.assertTrue(actuallastName.isDisplayed(), "VerifyContactInformationTest that warning message is displayed:");
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
        List<WebElement> elementList = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println("elementList.size() = " + elementList.size());
        elementList.get(0).click();
//        Step 9. Enter any valid date of birth.
        driver.findElement(By.name("birthday")).sendKeys("05/13/2013");

//        Step 10. Select any department.

        WebElement department= driver.findElement(By.name("department"));
        Select dropdown= new Select(department);
        dropdown.selectByValue("TO");

        String expectedOption="Tourism Office";
        String actualOption=dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

//        Step 11. Enter any job title.

        WebElement job_title= driver.findElement(By.name("job_title"));
        Select dropdownJobTitle= new Select(job_title);
        dropdownJobTitle.selectByVisibleText("QA");

        String expectedTitle="QA";
        String actualTitle=dropdownJobTitle.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");


//        Step 12. Select java as a programming language.

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".form-check-input"));
        System.out.println("checkBoxes.size() = " + checkBoxes.size());
        for (int i = 0; i < 3; i++) {
            checkBoxes.get(1).click();
        }
        Assert.assertTrue(checkBoxes.get(1).isSelected(), "verify that java as a programming language is selected.");
//        Step 13. Click Sign up.

        driver.findElement(By.id("wooden_spoon")).click();

//        Step 14. VerifyContactInformationTest that following success message is displayed: “You've successfully completed registration!”

        String expectedMessage = "You've successfully completed registration!";

        String actualMessage = driver.findElement(By.cssSelector("div p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage, "VerifyContactInformationTest that following success message is displayed");

    }








}
