package com.example.Assignment3;


        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import static org.junit.jupiter.api.Assertions.assertTrue;

public class seleniumTest {
    //String webDriverLocation = "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\chromedriver_win32\\chromedriver.exe";
    String webDriverLocation = "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\chromedriver.exe";
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

    @Test
    @DisplayName("Host and players press button and join game")
    public void players_join_game() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");
        WebElement button = hostBrowser.findElement(By.id("hostGameButton"));
        //assertTrue((button.isDisplayed()));
        //button.click();
        hostBrowser.findElement(By.id("nameField")).sendKeys("Hello Riyanson");
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);

        //WebElement e = hostBrowser.findElement(By.xpath("//*[text()='Find this text']"));
        WebElement e = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        System.out.println("e.isDisplayed(): " + e.isDisplayed() );
        assertTrue((e.isDisplayed()));
        System.out.println("Element with text(): " + e.getText() );
        String playersRemaining = "3 players left to join";
        System.out.println("Contains the players remaining? : " + e.getText().contains(playersRemaining) );
        //hostBrowser.findElement(By.name("Greet me!")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        WebElement player2Text = player2Browser.findElement(By.xpath("//*[text() != '']"));
        String player2Message = "Welcome Player 2";
        assertTrue((player2Text.getText().contains(player2Message)));

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        WebElement player3Text = player3Browser.findElement(By.xpath("//*[text() != '']"));
        String player3Message = "Welcome Player 3";
        assertTrue((player3Text.getText().contains(player3Message)));

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        WebElement player4Text = player4Browser.findElement(By.xpath("//*[text() != '']"));
        String player4Message = "Welcome Player 4";
        assertTrue((player4Text.getText().contains(player4Message)));


        hostBrowser.close();
        player2Browser.close();
        player3Browser.close();
        player4Browser.close();

    }







}