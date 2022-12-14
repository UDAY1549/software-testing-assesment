package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        List<WebElement> lists =driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        List<WebElement> list =driver.findElements(By.xpath("//*[@class='inventory_item_price']"));

        for(int i=0;i<lists.size();i++) {
            System.out.println(lists.get(i).getText() + "---"+ list.get(i).getText());
        }

        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.id("first-name")).sendKeys("uday");
        driver.findElement(By.id("last-name")).sendKeys("kumar");
        driver.findElement(By.id("postal-code")).sendKeys("1686");
        driver.findElement(By.id("continue")).click();

        WebElement totalItemsPrice = driver.findElement(By.xpath("//div[@class='cart_list']"));
        System.out.println("totalItemsPrice: "+totalItemsPrice.getText());

        WebElement taxPrice = driver.findElement(By.xpath("//div[@class='cart_list']"));
        System.out.println("taxPrice: "+taxPrice.getText());

        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='cart_list']"));
        System.out.println("totalPrice: "+totalPrice.getText());

        driver.findElement(By.id("finish")).click();

        WebElement orderProduct = driver.findElement(By.id("checkout_complete_container"));
        try {
            Assert.assertEquals(orderProduct.isDisplayed(), true);
        } catch (AssertionError e) {
            System.out.println("order confirmation screen is not displayed");
            throw e;
        }
        System.out.println("order confirmation screen is displayed");
    }
}