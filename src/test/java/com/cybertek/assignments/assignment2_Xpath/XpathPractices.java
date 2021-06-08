package com.cybertek.assignments.assignment2_Xpath;
/*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
   a. “Home” link
   b. “Forgot password” header
   c. “E-mail” text
   d. E-mail input box
   e. “Retrieve password” button
4.Print text of a,b,c,e and put some email to d
 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathPractices {

    public static void main(String[] args) {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

//        2. Go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

//        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
//        a. “Home” link
        WebElement homeLink= driver.findElement(By.xpath("//a[@class='nav-link']"));
//        b. “Forgot password” header
        WebElement forgetPasswordHeader = driver.findElement(By.xpath("//div[@class='container']//h2"));

//        c. “E-mail” text
        WebElement email= driver.findElement(By.xpath("//*[@for='email']"));

//        d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));

//        e. “Retrieve password” button
        WebElement retrieveButton=driver.findElement(By.xpath("//button[@id='form_submit']"));


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
        String confirmationMessage=driver.findElement(By.xpath("//h4[@name='confirmation_message']")).getText();


            if(confirmationMessage.equals("Your e-mail's been sent!")){
                System.out.println("PASS");
                System.out.println("confirmation Message = " + confirmationMessage);
            }else{
                System.out.println("FAIL");
                System.out.println("confirmation Message = " + confirmationMessage);
                System.out.println("expected Message = " + "Your e-mail's been sent!");
            }





    }
}
