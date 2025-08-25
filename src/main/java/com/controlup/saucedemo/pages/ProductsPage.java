package com.controlup.saucedemo.pages;

import com.controlup.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsHeader;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> inventoryItems;

    @FindBy(xpath = "(//div[@class='inventory_item'][1])//div[@class='inventory_item_name ']")
    private List<WebElement> firstInventoryItem;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartButton;

    public boolean isHeaderVisible(){
        return productsHeader.isDisplayed();
    }

    public int getNumberOfInventoryItems() {
        return inventoryItems.size();
    }

    public String addProductToCardByIndex(int index){
        String productName = itemNames.get(index).getText();
        addToCartButtons.get(index).click();
        return productName;
    }

    public CartPage openCart(){
        shoppingCartButton.click();
        return new CartPage(driver);
    }

}
