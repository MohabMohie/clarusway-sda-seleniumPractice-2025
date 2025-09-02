package com.github.MohabMohie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
//        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

//        driver.get("https://www.google.com/");
//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().back();

//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println("Navigation successful");
        driver.quit();
    }
}