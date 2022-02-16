package org.daleks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class N1Filters {

    @Test
    public void N1_Product_have_filters () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_98.0.4758.80\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
            Thread.sleep(2000);

            /*WebElement element = driver.findElement(By.xpath(
                    "//div[@data-filter-name='fbrand']/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
            String str = element.getText();
            String actual = str_actual;
            System.out.println(str);
            Assert.assertEquals(str, actual); */

            WebElement brand = driver.findElement(By.xpath(
                    "//div[@data-filter-name='fbrand']/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
            String str_brand = brand.getText();
            System.out.println(str_brand);
            Assert.assertEquals(str_brand, "Бренд");

            WebElement discount = driver.findElement(By.xpath(
                    "//div[@data-filter-name='discount']" +
                            "/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
            String str_discount = discount.getText();
            System.out.println(str_discount);
            Assert.assertEquals(str_discount, "Скидка");

            WebElement priceU = driver.findElement(By.xpath(
                    "//div[@data-filter-name='priceU']/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
            String str_priceU = priceU.getText();
            System.out.println(str_priceU);
            Assert.assertEquals(str_priceU, "Цена, ₽");

        }
        catch (InterruptedException e) {

            e.printStackTrace();

        }
        finally {

            Thread.sleep(7000);
            driver.quit();

        }

    }

}
