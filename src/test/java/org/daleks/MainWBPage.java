package org.daleks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWBPage {

    private WebDriver driver;

    public MainWBPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openMainWBPage() throws InterruptedException {
        driver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@id='applySearchBtn']")
    private WebElement searchButton;

    public void inputProductSearch(String input) {
        searchInput.sendKeys(input);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
