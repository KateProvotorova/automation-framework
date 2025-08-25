package com.controlup.saucedemo.pages;

import com.controlup.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.controlup.saucedemo.utils.ConfigReader;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public void open(){
        driver.get(ConfigReader.get("base.url"));
    }

    public void enterUserName(String userName){
        userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void loginAs(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

}
