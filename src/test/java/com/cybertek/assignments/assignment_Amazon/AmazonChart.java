package com.cybertek.assignments.assignment_Amazon;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonChart {

    WebDriver driver;

    @Test
    public void test1(){
            // 1.	Go to https://www.amazon.com
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

//            2.	Search for "hats for men" (Configurationdan cagir)

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("hats for men");
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

//            3.	Add the first hat appearing to Cart with quantity 2
        driver.findElement(By.xpath("(//div/h2/a/span)[1]")).click();


        //
        //driver.findElement(By.xpath("(//span[@class='a-button-text a-declarative'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-padding-none'])[1]//span[@class='a-button-text a-declarative']")).click();

        List<WebElement> quantityElements = driver.findElements(By.xpath("//li[@class='a-dropdown-item']"));

        System.out.println("quantityElements.size() = " + quantityElements.size());

        quantityElements.get(1).click();

        driver.findElement(By.cssSelector("#add-to-cart-button")).click();

        // Total price of the selected products before going into the chart

        String priceBeforeChart = driver.findElement(By.xpath("//div[@id='hlb-subcart']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")).getText();
        System.out.println("priceBeforeChart = " + priceBeforeChart);

        String itemNumberBeforeChart = driver.findElement(By.cssSelector("#hlb-ptc-btn-native")).getText();
        System.out.println("itemNumberBeforeChart = " + itemNumberBeforeChart);

        String substringQuantityItem1 = itemNumberBeforeChart.substring(itemNumberBeforeChart.indexOf('('), itemNumberBeforeChart.length());
        System.out.println("substringQuantityItem1 = " + substringQuantityItem1);


//            4.	Open cart and assert that the total price and quantity are correct

        driver.findElement(By.cssSelector("#hlb-view-cart-announce")).click();

        WebElement totalQuantity = driver.findElement(By.id("sc-subtotal-label-activecart"));
        String quantity= totalQuantity.getText();
        System.out.println("quantity = " + quantity);

        String substringQuantity2 = quantity.substring(quantity.indexOf('('), quantity.length() - 1);
        System.out.println("substringQuantity2 = " + substringQuantity2);

        Assert.assertEquals(substringQuantity2, substringQuantityItem1, "verify that the total quantity are correct");

        WebElement totalPrice = driver.findElement(By.cssSelector("#sc-subtotal-amount-buybox>span"));
        String price = totalPrice.getText();
        System.out.println("price = " + price);


        Assert.assertEquals(price,priceBeforeChart, "verify that the total price is correct");


//            5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3

        driver.findElement(By.cssSelector("#a-autoid-0-announce")).click();
        List<WebElement> dropBoxBaseballCap = driver.findElements(By.xpath("//li[@class='a-dropdown-item quantity-option']"));

        dropBoxBaseballCap.get(1);

//            6.	Assert that the total price and quantity has been correctly changed




    }



//        @AfterMethod
//        public void test2() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//        }
//
//

}
