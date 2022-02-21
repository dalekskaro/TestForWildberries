package org.daleks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {

    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//span[@class='good-info__good-name'])[1]")
    private WebElement productInBasket;

    @FindBy(xpath = "(//span[@class='good-info__good-name'])[1]")
    private WebElement nameProductInBasket;

    public void navigateToBasket() {
        driver.navigate().to("https://www.wildberries.ru/lk/basket");
    }

    public void waitingProductInBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(productInBasket));
    }

    public String nameProductInBasketText() {
        waitingProductInBasket();
        StringBuilder str = new StringBuilder(nameProductInBasket.getText());
        str.replace(str.lastIndexOf(","), str.lastIndexOf(",") + 1, "");
        String name = str.toString();
        return name;
    }
}