package com.controlup.saucedemo.pages;

import com.controlup.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement inventoryItemFromCart;

    public String getInventoryName(){
       return inventoryItemFromCart.getText();
    }

}
