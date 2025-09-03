package TestPackage;

import org.junit.jupiter.api.*;
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
        Assertions.assertNotEquals("Google", actualTitle);
//        driver.quit();
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
