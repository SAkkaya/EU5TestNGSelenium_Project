
package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {
/*          // default constructor olusturacak, dafault constructor icinde de super() keyword oldugu icin otomatik olark
                inherit edilen constructor icindede parametre olmadigi icin aldir direk
    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }
*/
    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

}