package org.daleks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage {

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@data-filter-name='fbrand']/div[@class='filter__title j-b-city-dropdown j-filter-title']")
    private WebElement filterBrand;

    @FindBy(xpath = "//div[@data-filter-name='discount']/div[@class='filter__title j-b-city-dropdown j-filter-title']")
    private WebElement filterDiscount;

    @FindBy(xpath = "//div[@data-filter-name='priceU']/div[@class='filter__title j-b-city-dropdown j-filter-title']")
    private WebElement filterPriceU;

    @FindBy(xpath = "//div[@class='product-card-list']/div[@data-card-index='0']")
    private WebElement firstCardProduct;

    @FindBy(xpath = "//a[@class='btn-main-sm j-add-to-basket']")
    private WebElement buttonAddToBasket;

    @FindBy(xpath = "//a[contains(@class,'btn-main-sm j-add-to-basket active')]")
    private WebElement buttonAddedToBasket;

    @FindBy(xpath = "(//span[contains(@class,'goods-name')])[1]")
    private WebElement nameFirstProduct;

    @FindBy(xpath = "//div[@class='navbar-pc__item j-item-basket']//a[@class='navbar-pc__link']")
    private WebElement buttonToBasket;

    @FindBy(xpath = "//button[@class='btn-heart j-add-to-postpone']")
    private  WebElement buttonAddToPostpone;

    @FindBy(xpath = "//div[@id='catalog_sorter']")
    private  WebElement sorterText;

    @FindBy(xpath = "//span[@class='goods-count']/span[@data-link='html{spaceFormatted:model.pagerModel.pagingInfo.totalItems}']")
    private WebElement productCount;

    @FindBy(xpath = "//div[@id='catalog-content']/div[@class='product-card-list']")
    private WebElement cardList;

    @FindBy(xpath = "//div[@class='product-card-list']/div[@data-card-index='3']")
    private WebElement thirdCardProduct;

    @FindBy(xpath = "//div[@class= 'product-card__brand-name']")
    private WebElement nameProduct;

    public void openCatalog() {
        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
    }

    public void navigateCatalog(){
        driver.navigate().to("https://www.wildberries.ru/catalog/krasota/makiyazh");
    }

    public String nameProductText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(nameFirstProduct));
        String nameProductText = nameFirstProduct.getText();
        return nameProductText;
    }

    public String getCardListText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cardList));
        String cardListText = cardList.getText();
        return cardListText;
    }

    public String getFilterBrandText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(filterBrand));
        String filterBrandText =  filterBrand.getText();
        return filterBrandText;
    }

    public String getFilterDiscountText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(filterDiscount));
        String filterDiscountText =  filterDiscount.getText();
        return filterDiscountText;
    }

    public String getFilterPriceUText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(filterPriceU));
        String filterPriceUText =  filterPriceU.getText();
        return filterPriceUText;
    }

    public void clickButtonAddToBasket() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstCardProduct).click(buttonAddToBasket).release().build().perform();
        Thread.sleep(1000);
    }

    public void waitingClickButtonAddToBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(buttonAddedToBasket));
    }

    public String buttonAddedToBasketText() {
        waitingClickButtonAddToBasket();
        String addedToBasketText = buttonAddedToBasket.getText();
        return addedToBasketText;
    }

    public String nameFirstProductText() {
        waitingClickButtonAddToBasket();
        String nameFirstProductText = nameFirstProduct.getText();
        return nameFirstProductText;
    }

    public void clickButtonToBasket() throws InterruptedException {
        buttonToBasket.click();
        Thread.sleep(1000);
    }

    public void clickButtonAddToPostpone() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstCardProduct).click(buttonAddToPostpone).release().build().perform();
        Thread.sleep(1000);
    }

    public String getSorterText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sorterText));
        String sorterTextStr = sorterText.getText();
        return sorterTextStr;
    }

    public String productCountText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(productCount));
        String productCountText =  productCount.getText();
        return productCountText;
    }

}