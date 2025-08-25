package com.controlup.saucedemo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initDriver() {

        String browser = System.getProperty("browser", "chrome");
        WebDriver driver;


        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        break;

        case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;

        case "edge":
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;

        default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);

    }
    driver.manage().

    window().

    maximize();
        return driver;
}
}