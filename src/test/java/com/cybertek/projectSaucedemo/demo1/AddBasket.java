package com.cybertek.projectSaucedemo.demo1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddBasket {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to "https://www.saucedemo.com/"
        driver.get("https://www.saucedemo.com/");
        //enter use name
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");
        //enter password
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        // click login
       driver.findElement(By.cssSelector("input[type='submit']")).click();
        //add to bag 'Sauce Labs Backpack'
        driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']")).click();
        //get price
        WebElement price =driver.findElement(By.cssSelector(".inventory_item_price"));
        String getPrice=price.getText();
        System.out.println("getPrice = " + getPrice);
        String priceWithout$ = getPrice.substring(1);
        System.out.println("priceWithout$ = " + priceWithout$);
        double priceDouble=Double.parseDouble(priceWithout$ );
        System.out.println("priceDouble = " + priceDouble);
        //add-basket Sauce Labs Onesie
        driver.findElement(By.cssSelector("div button[id='add-to-cart-sauce-labs-onesie']")).click();
        //go to chart
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
        //remove labas Onesie
        driver.findElement(By.cssSelector("button[id='remove-sauce-labs-onesie']")).click();
        //find Sauce labs backpack price on checkout page
        WebElement CheckOut =driver.findElement(By.cssSelector(".inventory_item_price"));
        String priceCheckOut=CheckOut.getText();
        System.out.println("priceCheckOut = " + priceCheckOut);
        String priceWithout$2 = priceCheckOut.substring(1);
        double priceOutDouble=Double.parseDouble(priceWithout$2);
        System.out.println("priceOutDouble = " + priceOutDouble);
        // check does prices equal
        if(priceDouble==priceOutDouble){
            System.out.println("PASS");
            System.out.println("Price Equal");
        }else{
            System.out.println("FAIL");
            System.out.println("priceDouble = " + priceDouble);
            System.out.println("priceOutDouble = " + priceOutDouble);
        }
        //click checkout
        driver.findElement(By.cssSelector("#checkout")).click();

        //enter firstname lastname zipcode  and click continue
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Ali");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Kaya");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("77600");
        driver.findElement(By.cssSelector("#continue")).click();
        //does checkout overview price equal main page's price

        String overviewPrice=driver.findElement(By.cssSelector(".summary_subtotal_label")).getText();
        if(getPrice.equals(overviewPrice)){
            System.out.println("PASS");
            System.out.println("Price Equal");
        }else{
            System.out.println("FAIL");
            System.out.println("getPrice = " + getPrice);
            System.out.println("priceCheckOut = " + overviewPrice);
        }
        //click finish
        driver.findElement(By.cssSelector("#finish")).click();

        String checkOutComplete= driver.findElement(By.cssSelector(".title")).getText();

        if(checkOutComplete.equalsIgnoreCase("Checkout: Complete!")){
            System.out.println("PASS-Test complete");
            System.out.println(checkOutComplete);
        }else{
            System.out.println("FAIL");
            System.out.println(checkOutComplete);
        }
        Thread.sleep(3000);
        driver.quit();

    }

}
