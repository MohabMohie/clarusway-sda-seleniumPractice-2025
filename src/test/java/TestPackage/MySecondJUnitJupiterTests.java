package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySecondJUnitJupiterTests {
    WebDriver driver;

    @Test
    void myPassingTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        By textInput = By.id("my-text-id");
        driver.findElement(textInput).sendKeys("my", Keys.TAB, "first", Keys.TAB, "text");

//        driver.findElement(By.tagName("input")).sendKeys("write some stuff");
//        driver.findElement(By.id("dummyIdThatDoesntExist")).sendKeys("write some stuff");

//        var elementsEmpty = driver.findElements(By.id("dummyIdThatDoesntExist"));
//        var elementsUnique = driver.findElements(By.id("my-text-id"));
//        var elements = driver.findElements(By.tagName("input"));
    }

    @Test
    void loginToSauceDemo(){
        driver.get("https://www.saucedemo.com/");

        // option #1: industry standard
        By userNameInput = By.id("user-name");
        By passwordInput = By.id("password");
        By loginButton = By.id("login-button");


//        driver.findElement(userNameInput).clear();
        driver.findElement(userNameInput).sendKeys("standard_user");
        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

//        driver.findElement(loginButton).submit(); //not recommended sa per the official selenium userguide https://www.selenium.dev/documentation/webdriver/elements/interactions/#submit

        // category #1 element information getters
        driver.findElement(userNameInput).getText();
        driver.findElement(userNameInput).getDomAttribute("name");
        driver.findElement(userNameInput).getDomProperty("value");
//        driver.findElement(userNameInput).getAttribute("class"); //recommended by Mohab for use with Appium and not web elements

        driver.findElement(userNameInput).isDisplayed();
        driver.findElement(userNameInput).isEnabled();
        driver.findElement(userNameInput).isSelected(); //returns true if the element has the dom attribute selected, or checked

        // category #2 element information getters
        driver.findElement(userNameInput).getCssValue("color"); //rgb(33, 37, 41)

        driver.findElement(userNameInput).getTagName();
        driver.findElement(userNameInput).getAriaRole();
        driver.findElement(userNameInput).getAccessibleName();

        driver.findElement(userNameInput).getLocation();
        driver.findElement(userNameInput).getRect();
        driver.findElement(userNameInput).getSize();


        // synchronize the test code with the browser state
        // wait for the page to be loaded

        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl );

//        // option #2: the shortcut
//        By userNameInput = By.id("user-name");
//        driver.findElement(userNameInput).sendKeys("standard_user", Keys.TAB, "secret_sauce", Keys.TAB, Keys.SPACE);
//
//        driver.findElement(userNameInput).sendKeys(
//                Keys.chord(Keys.CONTROL, "a")
//                , Keys.chord(Keys.CONTROL, "c")
//                , Keys.TAB
//                , Keys.chord(Keys.CONTROL, "v"));

    }

    @BeforeEach
    void beforeEachTest() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEachTest() {
        driver.quit();
    }
}
