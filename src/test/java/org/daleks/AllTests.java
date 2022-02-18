package org.daleks;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

class AllTest {

    public static WebDriver driver;
    public static CatalogPage catalogPage;
    public static BasketPage basketPage;

    @BeforeAll
    static void setupClass() {
        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver_98.0.4758.80\\chromedriver.exe");
    }

    @BeforeEach
    void setupTest() throws InterruptedException {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        catalogPage = new CatalogPage(driver);
        basketPage = new BasketPage(driver);

        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        catalogPage.openCatalog();
        //catalogPage.navigateCatalog();
        Thread.sleep(7000);

        Runtime.getRuntime().addShutdownHook(
                new Thread(()->{
                    driver.quit();
                    driver = null;
                }));
    }

    @Test
    void productHaveFilters1() {

        Assert.assertEquals("Бренд", catalogPage.getFilterBrandText());
        Assert.assertEquals("Скидка", catalogPage.getFilterDiscountText());
        Assert.assertEquals("Цена, ₽", catalogPage.getFilterPriceUText());
    }

    @Test
    void addProductInBasket2and3() throws InterruptedException {

        catalogPage.clickButtonAddToBasket();
        catalogPage.waitingClickButtonAddToBasket();
        String str1 = catalogPage.nameFirstProductText();
        System.out.println("1: " + str1);
        Assert.assertEquals("В корзине", catalogPage.buttonAddedToBasketText());

        catalogPage.clickButtonToBasket();

        basketPage.waitingProductInBasket();
        String str2 = basketPage.nameProductInBasketText();
        System.out.println("2: " + str2);

        Assert.assertEquals(str1, str2);

        catalogPage.openCatalog();

    }

    @Test
    void addInPostpone4() throws InterruptedException {

        catalogPage.clickButtonAddToPostpone();
        catalogPage.openCatalog();

    }

    @Test
    void sorterProduct5() {

        System.out.println(catalogPage.getSorterText());

    }

    @Test
    void productCount6(){

        System.out.println("Count: " + catalogPage.productCountText());

    }

}