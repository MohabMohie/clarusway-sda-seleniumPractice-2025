package TestPackage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstJUnitJupiterTests {
    WebDriver driver;

    @Test
    void myPassingTest() {
//        WebDriver driver;
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Title: " + actualTitle);

        Assertions.assertEquals("Google", actualTitle);
        //TODO: discuss the limitations of assertions methods and other 3rd party alternatives
//        driver.quit();
    }

    @Test
    void myFailingTest() {
//        WebDriver driver;
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Title: " + actualTitle);
//        try {
//            Assertions.assertEquals("GoogleX", actualTitle);
//        } catch (org.opentest4j.AssertionFailedError e) {
//            System.out.println("Assertion Failed: " + e.getMessage());
//        } finally {
//            driver.quit();
//        }
//        Assertions.assertEquals("GoogleX", actualTitle);
        Assertions.assertNotEquals("Google", actualTitle, "Checking the page title failed, actual title was Google.");
//        driver.quit();
    }

    @Test
    void checkPageUrlContainsAmazon(){
        driver.get("https://www.amazon.com/");
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + actualUrl);
//        Assertions.assertTrue(actualUrl.toLowerCase().contains("Amazon".toLowerCase()));
        Assertions.assertFalse(actualUrl.contains("dummy"));
    }

    @Test
    void typeTextIntoInputField(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(By.id("my-text-id")).sendKeys("write some stuff");
        // TODO: how do we test that locator to make sure that it is unique? and valid.
        // TODO: discuss findElements
    }

//    @BeforeAll
//    static void setup() {
//        System.out.println("Setting up Browser");
//    }
//
//    @AfterAll
//    static void teardown() {
//        System.out.println("Closing Browser");
//    }

    @BeforeEach
    void beforeEachTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEachTest() {
        driver.quit();
    }
}
