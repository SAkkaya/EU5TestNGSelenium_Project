
package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * VerifyContactInformationTest that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */



    @Test
    public void test1(){


        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();  // DashboardPage ile object olusturdum , bu object ile BasePage deki ready methodlara ulasmak istedim

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"VerifyContactInformationTest subtitle");

     // navigateToModule()  => navigate between common pages
        dashboardPage.navigateToModule("Activities", "Calendar Events");


        CalendarEventsPage calendarEventsPage = new CalendarEventsPage(); // created new object here
        BrowserUtils.waitFor(2); // it has Error handling inside you dont need to handle it with try and catch
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","VerifyContactInformationTest subtitle Calendar Events");


    }

}

