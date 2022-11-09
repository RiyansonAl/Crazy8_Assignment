package com.example.Assignment3;


        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import static org.junit.jupiter.api.Assertions.assertTrue;

public class seleniumTest {
    String webDriverLocation = "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\chromedriver_win32\\chromedriver.exe";
    String webDriverType = "webdriver.chrome.driver";
    @Test
    @DisplayName("Selenium Test")
    public void site_header_is_on_home_page() {
        WebDriver browser;

        System.setProperty("webdriver.chrome.driver", "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://saucelabs.com");
        WebElement header = browser.findElement(By.id("headerMainNav"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

    @Test
    @DisplayName("Spring boot Test")
    public void spring_boot_test() {
        WebDriver browser;

        System.setProperty(webDriverType, webDriverLocation);
        browser = new ChromeDriver();
        browser.get("http://localhost:8080");
        WebElement header = browser.findElement(By.id("nameForm"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

    @Test
    @DisplayName("Game Host Main Page - Host")
    public void gamehost_main_page() {
        WebDriver browser;

        System.setProperty(webDriverType, webDriverLocation);
        browser = new ChromeDriver();
        browser.get("http://localhost:8080");
        WebElement header = browser.findElement(By.id("hostGameButton"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

    @Test
    @DisplayName("Game Host Main Page- Join Game")
    public void gamehost_main_page_join() {
        WebDriver browser;

        System.setProperty(webDriverType, webDriverLocation);
        browser = new ChromeDriver();
        browser.get("http://localhost:8080");
        WebElement header = browser.findElement(By.id("joinGameButton"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

    @Test
    @DisplayName("Press the Host button on main page and start websocket")
    public void press_host_button() {
        WebDriver browser;

        System.setProperty(webDriverType, webDriverLocation);
        browser = new ChromeDriver();
        browser.get("http://localhost:8080");
        WebElement button = browser.findElement(By.id("hostButton"));
        assertTrue((button.isDisplayed()));
        button.click();
        browser.close();
    }







}