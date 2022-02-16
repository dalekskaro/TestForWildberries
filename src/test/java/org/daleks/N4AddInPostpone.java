package org.daleks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class N4AddInPostpone {

    @Test
    public void N4_Add_in_postpone () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_98.0.4758.80\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
            Thread.sleep(2000);

            WebElement first_card_product = driver.findElement(By.xpath(
                    "//div[@class='product-card-list']/div[@data-card-index='0']"));
            WebElement button_add_to_postpone = driver.findElement(By.xpath(
                    "//button[@class='btn-heart j-add-to-postpone']"));

            Actions actions = new Actions(driver);
            actions.moveToElement(first_card_product).click(button_add_to_postpone).release().build().perform();

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
