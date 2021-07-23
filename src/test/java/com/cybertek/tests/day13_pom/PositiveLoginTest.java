package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage  = new LoginPage();

        String username = ConfigurationReader.get("driver_username");   // no hardcoded no static username and password in my Framework
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);  // instead of driver.findelement ()
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

 //       loginPage.loginAsDriver();      //line 16-21 arasini commnet e alirsam bu satir yetiyor bana

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

//        loginPage.usernameInput.sendKeys(username);
//        loginPage.passwordInput.sendKeys(password);
//        loginPage.loginBtn.click();

        loginPage.login(username,password);    //loginPage den login methodu ve parametresini girdik

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");


    }

/*      bunun yerine asagidakini yaptik
    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

//        loginPage.usernameInput.sendKeys(username);
//        loginPage.passwordInput.sendKeys(password);
//        loginPage.loginBtn.click();

        loginPage.login(username,password);    //loginPage den login methodu ve parametresini girdik
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }
*/



    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }




}
