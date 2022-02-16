package org.daleks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class N6ProductCount {

    @Test
    public void N6_Product_count() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver_98.0.4758.80\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
            Thread.sleep(2000);

            WebElement element = driver.findElement(By.xpath(
                    "//span[@class='goods-count']/span[@data-link='html{spaceFormatted:model.pagerModel.pagingInfo.totalItems}']"));
            System.out.println("Product count = " + element.getText());

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            Thread.sleep(7000);
            driver.quit();

        }

    }

}
