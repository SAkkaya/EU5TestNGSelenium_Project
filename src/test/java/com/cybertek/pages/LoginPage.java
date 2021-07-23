package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
                    //login page i neden BAsePage ile extend etmedim, cunku common values i yok login olduktan sonra mainpage ile, yani navigation, subtitle... yok loginde
public class LoginPage {  //we are gonna keep our locaters and methods in this pages separately in a more structured way

    // login page central control page for the locater for login page for all hundrends of test cases

    // 1. Create a public Constructor   so that create a PageObject model page
    // PageFactory ==> selenium Class , converting the page to PageObject Class
    // initElemenets methods ==> that methods  initiliaze the elements that we use in this class
    // Driver.get() ++. same object during the rinTime, everywher in your application
    //this => pointing the element in this page,and representing each @annotations that i am using in this class

    public LoginPage(){ PageFactory.initElements(Driver.get(),this);    //PageFactory class allows us to use @findBy annotation, basically structure
                // bunu direk POM page lere kopyalayacagiz daha sonra
    }

    //    @FindBy  => Selenium annotaion

    // driver.findElement (By.id("prependedInput));  ==> we are converting this in to the PageObjectModel element by @FindBy

    /*
    @FindBy(id="prependedInput")    // connected to   public WebElement usernameInput;
    public WebElement usernameInput;
     */

    @FindAll({       // ikisinden birini bulursa hangisi olursa ( OR logic)
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })
    public WebElement usernameInput;

    /*
    @FindBys({            // ikisini birden saglamali  ( AND logic)
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })
     */


    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"));
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    /*
    @FindBy(css = ".btn.btn-primary") // birden cok WebElement icin List kullaniyoruz
    public List<WebElement> buttons;
     */

    // we are using 3 Webelemnt , 2 of them send parameters  (sendkeys) username and password, and we are clicking the button
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();


    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }


    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }



}
