package com.github.MohabMohie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    /**
     * https://www.selenium.dev/documentation/webdriver/getting_started/first_script/
     * @param args
     */
    public static void main(String[] args) {
        // 1. start the session
        WebDriver driver;
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();

//        ChromeOptions chromeOptions;
//        chromeOptions = new ChromeOptions();
//        // https://developer.chrome.com/docs/chromedriver/capabilities
//        // run the browser in a specifc dimension setting and set the point and location and dimensions by default
//        chromeOptions.addArguments("window-size=1080,720");
//        chromeOptions.addArguments("window-position=0,0");
//        driver = new ChromeDriver(chromeOptions);

        // 2. Take action on browser
//        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

//        driver.get("https://www.google.com/");
//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

//        driver.manage().window().maximize();
//        driver.manage().window().minimize();
//        driver.manage().window().fullscreen();
//        driver.manage().window().setSize(new org.openqa.selenium.Dimension(720, 480));
//        driver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));

        // 3. Request browser information
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("Page Source: " + pageSource);

        // 8. close the session
        driver.quit();
    }
}