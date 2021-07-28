package com.cybertek.assignments.hw_day15_contactInfo;

import com.cybertek.pages.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage extends BasePage {

    @FindBy(css = "a[class='email']")
    public WebElement email;

    @FindBy(css = "h1[class='user-name']")
    public WebElement username;

    @FindBy(css = "a[class='phone']")
    public WebElement phone;


}
