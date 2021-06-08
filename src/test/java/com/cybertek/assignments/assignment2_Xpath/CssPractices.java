package com.cybertek.assignments.assignment2_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssPractices {

    public static void main(String[] args) {
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

//        2. Go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

//        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
//        a. “Home” link
        WebElement homeLink= driver.findElement(By.cssSelector(".nav-link"));
//        b. “Forgot password” header
        WebElement forgetPasswordHeader = driver.findElement(By.cssSelector(".example>h2"));
       // WebElement forgetPasswordHeader = driver.findElement(By.cssSelector("body h2"));

//        c. “E-mail” text
        WebElement email= driver.findElement(By.cssSelector("div label"));
        //WebElement email= driver.findElement(By.cssSelector("label[for='email']"));

//        d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("div label~input"));

//        e. “Retrieve password” button
        WebElement retrieveButton=driver.findElement(By.cssSelector("i[class^='icon']")); //starts-with
        // WebElement retrieveButton=driver.findElement(By.cssSelector("i[class$='signin']")); // ends-with
        // WebElement retrieveButton=driver.findElement(By.cssSelector("i[class*='2x']"));  //contains                                                                                   //i[class*='2x']

//        4.Print text of a,b,c,e
        //Print text of a
        String homeLinkText = homeLink.getText();
        System.out.println("homeLinkText = " + homeLinkText);
        //Print text of b
        String forgetPasswordHeaderText = forgetPasswordHeader.getText();
        System.out.println("forgetPasswordHeaderText = " + forgetPasswordHeaderText);
        //Print text of c
        String emailText=email.getText();
        System.out.println("emailText = " + emailText);

        //put some email to d
        emailInputBox.sendKeys("kaya@gmail.com");
        String enteredEmail = emailInputBox.getAttribute("value");
        System.out.println("enteredEmail = " + enteredEmail);

        //Print text of e
        String retrieveButtonText=retrieveButton.getText();
        System.out.println("retrieveButtonText = " + retrieveButtonText);
        retrieveButton.click();
        String confirmationMessage=driver.findElement(By.cssSelector("div h4")).getText();

        if(confirmationMessage.equals("Your e-mail's been sent!")){
            System.out.println("PASS");
            System.out.println("confirmation Message = " + confirmationMessage);
        }else{
            System.out.println("FAIL");
            System.out.println("confirmation Message = " + confirmationMessage);
            System.out.println("expected Message = " + "Your e-mail's been sent!");
        }

        driver.quit();
    }
}
