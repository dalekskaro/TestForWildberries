package org.daleks;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

class AllTest {

    public static WebDriver driver;
    public static CatalogPage catalogPage;
    public static BasketPage basketPage;
    public static MainWBPage mainWBPage;

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
        mainWBPage = new MainWBPage(driver);

        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        //catalogPage.openCatalog();
        //catalogPage.navigateCatalog();
        //Thread.sleep(7000);

        Runtime.getRuntime().addShutdownHook(
                new Thread(()->{
                    driver.quit();
                    driver = null;
                }));
    }


    @ParameterizedTest
    @CsvFileSource (resources = "/data.csv", numLinesToSkip = 1)
    void searchTest(String input) throws InterruptedException {

        mainWBPage.openMainWBPage();

        mainWBPage.inputProductSearch(input);
        mainWBPage.clickSearchButton();

        //System.out.println(catalogPage.nameProductText());

        boolean tOf = catalogPage.nameProductText().toLowerCase().contains(input.toLowerCase());
        //System.out.println(tOf);
        Assert.assertEquals(tOf, true);

    }

    @Test
    void productHaveFilters1() {

        catalogPage.openCatalog();
        Assert.assertEquals("Бренд", catalogPage.getFilterBrandText());
        Assert.assertEquals("Скидка", catalogPage.getFilterDiscountText());
        Assert.assertEquals("Цена, ₽", catalogPage.getFilterPriceUText());
    }

    @Test
    void addProductInBasket2and3() throws InterruptedException {

        catalogPage.openCatalog();
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

        catalogPage.openCatalog();
        catalogPage.clickButtonAddToPostpone();
        catalogPage.openCatalog();

    }

    @Test
    void sorterProduct5() {

        catalogPage.openCatalog();
        System.out.println(catalogPage.getSorterText());

    }

    @Test
    void productCount6(){

        catalogPage.openCatalog();
        System.out.println("Count: " + catalogPage.productCountText());

    }

}