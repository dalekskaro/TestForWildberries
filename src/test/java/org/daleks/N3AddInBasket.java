package org.daleks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class N3AddInBasket {

    @Test
    public void N3_Add_product_in_basket_check_in_basket () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_98.0.4758.80\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
            Thread.sleep(2000);

            WebElement first_card_product = driver.findElement(By.xpath(
                    "//div[@class='product-card-list']/div[@data-card-index='0']"));
            WebElement button_add_to_basket = driver.findElement(By.xpath(
                    "//a[@class='btn-main-sm j-add-to-basket']"));

            String str1 = driver.findElement(By.xpath("(//span[contains(@class,'goods-name')])[1]")).getText();
            System.out.println("1: " + str1);

            Actions actions1 = new Actions(driver);
            actions1.moveToElement(first_card_product).click(button_add_to_basket).release().build().perform();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//a[contains(@class,'btn-main-sm j-add-to-basket active')]")));

            driver.navigate().to("https://www.wildberries.ru/lk/basket");
            Thread.sleep(2000);

            WebElement product_in_basket = driver.findElement(By.xpath(
                    "(//span[@class='good-info__good-name'])[1]"));
            String str2 = product_in_basket.getText().replace(",", "");
            System.out.println("2: " + str2);

            Assert.assertEquals(str1, str2);

        }
        catch (InterruptedException e) {

            e.printStackTrace();

        }
        finally {

            Thread.sleep(1000);
            driver.quit();

        }

    }

}
