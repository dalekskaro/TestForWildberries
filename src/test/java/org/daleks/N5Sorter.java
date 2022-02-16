package org.daleks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class N5Sorter {

    @Test
    public void N5_Sorter_product () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_98.0.4758.80\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
            Thread.sleep(2000);

            ///WebElement brand = driver.findElement(By.xpath("//div[@class='inner-sorter']/div[@href='/catalog/krasota/makiyazh?sort=popular']"));
            WebElement element = driver.findElement(By.xpath(
                    "//div[@id='catalog_sorter']"));
            System.out.println(element.getText());
            //Assert.assertEquals(element.getText(), "");

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
