package org.daleks;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class AllTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() throws InterruptedException {
        Thread.sleep(7000);
        //driver.quit();
    }

    @Test
    void productHaveFilters1() {
        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");

        WebElement brand = driver.findElement(By.xpath(
                "//div[@data-filter-name='fbrand']/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
        String str_brand = brand.getText();
        Assert.assertEquals(str_brand, "Бренд");

        WebElement discount = driver.findElement(By.xpath(
                "//div[@data-filter-name='discount']" +
                        "/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
        String str_discount = discount.getText();
        Assert.assertEquals(str_discount, "Скидка");

        WebElement priceU = driver.findElement(By.xpath(
                "//div[@data-filter-name='priceU']/div[@class='filter__title j-b-city-dropdown j-filter-title']"));
        String str_priceU = priceU.getText();
        Assert.assertEquals(str_priceU, "Цена, ₽");
    }

    @Test
    void addProductInBasketCheckItselfPage2() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
        Thread.sleep(7000);

        WebElement first_card_product = driver.findElement(By.xpath(
                "//div[@class='product-card-list']/div[@data-card-index='0']"));
        WebElement button_add_to_basket = driver.findElement(By.xpath(
                "//a[@class='btn-main-sm j-add-to-basket']"));

        Actions actions1 = new Actions(driver);
        actions1.moveToElement(first_card_product).click(button_add_to_basket).release().build().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//a[contains(@class,'btn-main-sm j-add-to-basket active')]")));

        String str_in_basket = button_add_to_basket.getText();
        System.out.println(str_in_basket);
        Assert.assertEquals(str_in_basket, "В корзине");

    }

    @Test
    void addProductInBasketCheckInBasket3() throws  InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
        Thread.sleep(7000);

        WebElement first_card_product = driver.findElement(By.xpath(
                "//div[@class='product-card-list']/div[@data-card-index='0']"));
        WebElement button_add_to_basket = driver.findElement(By.xpath(
                "//a[@class='btn-main-sm j-add-to-basket'][1]"));

        String str1 = driver.findElement(By.xpath("(//span[contains(@class,'goods-name')])[1]")).getText();
        System.out.println("1: " + str1);

        Actions actions1 = new Actions(driver);
        actions1.moveToElement(first_card_product).click(button_add_to_basket).release().build().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//a[contains(@class,'btn-main-sm j-add-to-basket active')]")));
        //"//a[contains(@class,'btn-main-sm j-add-to-basket active')]"
        //"//a[@class='btn-main-sm j-add-to-basket active')]"

        driver.navigate().to("https://www.wildberries.ru/lk/basket");

        WebElement product_in_basket = driver.findElement(By.xpath(
                "(//span[@class='good-info__good-name'])[1]"));
        String str2 = product_in_basket.getText().replace(",", "");
        System.out.println("2: " + str2);

        Assert.assertEquals(str1, str2);

    }

    @Test
    void addInPostpone4(){


        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");

        WebElement first_card_product = driver.findElement(By.xpath(
                "//div[@class='product-card-list']/div[@data-card-index='0']"));
        WebElement button_add_to_postpone = driver.findElement(By.xpath(
                "//button[@class='btn-heart j-add-to-postpone']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(first_card_product).click(button_add_to_postpone).release().build().perform();

    }

    @Test
    void sorterProduct5() {

        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");

        WebElement element = driver.findElement(By.xpath(
                "//div[@id='catalog_sorter']"));
        System.out.println(element.getText());

    }

    @Test
    void productCount6(){

        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");

        WebElement element = driver.findElement(By.xpath(
                "//span[@class='goods-count']/span[@data-link='html{spaceFormatted:model.pagerModel.pagingInfo.totalItems}']"));
        System.out.println("Product count = " + element.getText());

    }

}