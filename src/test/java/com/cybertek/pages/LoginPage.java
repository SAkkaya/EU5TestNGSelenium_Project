package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //we are gonna keep our locaters and methods in this pages separately in a more structured way


    public LoginPage(){   // login page central control page for the locater for login page for all hundrends of test cases

        // 1. Create a public Constructor   so that create a PageObject model page
        // PageFactory ==> selenium Class , converting the page to PageObject Class
        // initElemenets methods ==> that methods  initiliaze the elements that we use in this class
        // Driver.get() ++. same object during the rinTime, everywher in your application
        //this => pointing the element in this page,and representing each @annotations that i am using in this class

        PageFactory.initElements(Driver.get(),this);    //PageFactory class allows us to use @findBy annotation, basically structure
                // bunu direk POM page lere kopyalayacagiz daha sonra
    }

    //    @FindBy  => Selenium annotaion

    // driver.findElement (By.id("prependedInput));  ==> we are converting this in to the PageObjectModel element by @FindBy

    @FindBy(id="prependedInput")    // connected to   public WebElement usernameInput;
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;



}
