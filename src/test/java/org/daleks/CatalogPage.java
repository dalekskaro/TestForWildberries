package org.daleks;

import org.openqa.selenium.WebDriver;

public class CatalogPage {

    WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCatalog() {
        driver.get("https://www.wildberries.ru/catalog/krasota/makiyazh");
    }

}
