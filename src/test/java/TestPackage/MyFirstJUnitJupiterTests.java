package TestPackage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

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

        // reusability, reliability, performance

        // option #1 -> find the element and act on it in the same line of code
        driver.findElement(By.id("my-text-id")).clear();
        driver.findElement(By.id("my-text-id")).sendKeys("write some stuff");
        // eliminated due to lack of reusability

        // option #2 -> find the element and store it in a variable then act on it
        WebElement myTextElement = driver.findElement(By.id("my-text-id"));
        myTextElement.clear();
        myTextElement.sendKeys("write some stuff");
        // satisfies reusability
        // has better performance than option #3 (less webdriver calls, 3 commands instead of 4)
        // can lead to StaleElementReferenceException, which impacts reliability

        // option #3 -> store the locator in a variable then use it to find the element and act on it
        By myTextLocator = By.id("my-text-id");
        driver.findElement(myTextLocator).clear();
        driver.findElement(myTextLocator).sendKeys("write some stuff");
        // satisfies reusability, satisfies reliability, is less performant than both options.

//        By form = By.id("login-form");
//        By username = By.name("my-text");
//        driver.findElement(form).findElement(username).sendKeys("write some stuff");
//
//        By username = new ByChained(By.id("login-form"), By.name("my-text"));
//        driver.findElement(username).sendKeys("write some stuff");


        By username = By.xpath("//*[@id='login-form']//*[@name='my-text']");
        driver.findElement(username).sendKeys("write some stuff");


        // performance category #1
        By.id("my-text-id"); // 1
//        By.className(""); // 3
//        By.name(""); // 2
        By.cssSelector("#my-text-id"); // 4

        // performance category #2
        By.xpath(""); // 8
//        By.linkText(""); // 6
//        By.partialLinkText(""); // 7
//        By.tagName(""); // 5

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
