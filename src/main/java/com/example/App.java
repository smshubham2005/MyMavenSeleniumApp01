package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        // Read system property
        String headless = System.getProperty("headless");

        if ("true".equals(headless)) {

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // SSL / Jenkins VM fixes
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            // Accept insecure certificates
            options.setAcceptInsecureCerts(true);
        }

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
