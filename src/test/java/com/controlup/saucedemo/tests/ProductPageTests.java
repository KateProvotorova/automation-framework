package com.controlup.saucedemo.tests;

import com.controlup.saucedemo.base.BaseTest;
import com.controlup.saucedemo.pages.CartPage;
import com.controlup.saucedemo.pages.LoginPage;
import com.controlup.saucedemo.pages.ProductsPage;
import com.controlup.saucedemo.utils.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {

    @Test(groups = {"ui"})
    public void validateNumberOfInventoryItems() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs(Credentials.STANDARD_USER, Credentials.PASSWORD);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isHeaderVisible(), "Title is not visible");
        Assert.assertEquals(productsPage.getNumberOfInventoryItems(), 6, "The number of inventory items is incorrect");
    }

    @Test(groups = {"ui"})
    public void validateInventoryItemInCard(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs(Credentials.STANDARD_USER, Credentials.PASSWORD);
        ProductsPage productsPage = new ProductsPage(driver);
        String addedInventoryItem = productsPage.addProductToCardByIndex(0);
        CartPage cartPage = productsPage.openCart();
        String inventoryItemInCart = cartPage.getInventoryName();
        Assert.assertEquals(addedInventoryItem, inventoryItemInCart, "Product in cart doesn't match added product");

    }

}
