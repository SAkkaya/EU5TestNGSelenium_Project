package com.cybertek.assignments.hw_day15_contactInfo;

import com.cybertek.pages.BasePage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPages extends BasePage {

//    buraya gerek yok dinamik olmaz sadece mariam icin calisir
//    @FindBy(xpath = "//table//tbody/tr[4]/td[contains(text(),'"+ email+ "')]")
//    public WebElement email;


    public static WebElement getEmail(String email){
        String xpath =  "//td[contains(text(), '"+ email+"') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }


}
