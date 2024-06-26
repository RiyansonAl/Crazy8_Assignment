package com.example.Assignment3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayingTwoAcceptanceTests {

    String webDriverLocation = "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\chromedriver.exe";
    String webDriverType = "webdriver.chrome.driver";


    @Test
    @DisplayName("Player 1 plays a 2 and the next player picks up 2 cards")
    public void acceptanceTestLine67() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "2C,3H";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4H";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "2C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        Player2HandRigged = "4H,6C,9H";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 plays a card
        String Player2CardPlayed = "6C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);


        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        String player1Message = "Player 3 Turn";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }

    @Test
    @DisplayName("Player 1 plays a 2, next player picks up 2 cards and still cant go and draws another 2 cards ")
    public void acceptanceTestLine68() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "2C,3H";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4H";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "2C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        Player2HandRigged = "4H,6S,9D";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Picks up a card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);

        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        Player2HandRigged = "4H,6S,9D,9H";
        String lastDrawnCard = "9H";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Picks up another card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);

        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        Player2HandRigged = "4H,6S,9D,6C";
        lastDrawnCard = "6C";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        String Player2CardPlayed = "6C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);


        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        String player1Message = "Player 3 Turn";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }

    @Test
    @DisplayName("Player 1 plays a 2, next player picks up 3 cards and ends turn")
    public void acceptanceTestLine69() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "2C,3H";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4H";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "2C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        Player2HandRigged = "4H,6S,9D";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Picks up a card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);

        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        Player2HandRigged = "4H,6S,9D,9H";
        String lastDrawnCard = "9H";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Picks up another card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);

        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        Player2HandRigged = "4H,6S,9D,9H,7S";
        lastDrawnCard = "7S";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Picks up a third card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);

        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        Player2HandRigged = "4H,6S,9D,9H,7S,5H";
        lastDrawnCard = "5H";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);


        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        String player1Message = "Player 3 Turn";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }

    @Test
    @DisplayName("Player 1 plays a 2,player 2 picks up 2 and plays another 2 making player 3 pickup 4 cards")
    public void acceptanceTestLine70() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "2C,3H";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4H";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        String Player3HandRigged = "7D";
        riggingBrowser.findElement(By.id("Player3HandText")).sendKeys(Player3HandRigged);
        riggingBrowser.findElement(By.id("Player3HandButton")).sendKeys(Keys.ENTER);


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "2C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        Player2HandRigged = "4H,2H,9D";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Plays a card
        String Player2CardPlayed = "2H";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 picks up 4 cards
        Player3HandRigged = "7D,5S,6D,6H,7C";
        riggingBrowser.findElement(By.id("Player3HandText")).clear();
        riggingBrowser.findElement(By.id("Player3HandText")).sendKeys(Player3HandRigged);
        riggingBrowser.findElement(By.id("Player3HandButton")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        String Player3CardPlayed = "6H";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);




        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        String player1Message = "Player 4 Turn";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }

    @Test
    @DisplayName("Player 1 plays a 2,player 2  plays 2 cards immediately")
    public void acceptanceTestLine72() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "2C,3H";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4C,6C,9D";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);



        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "2C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Plays a card
        String Player2CardPlayed = "4C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Plays a card
        Player2CardPlayed = "6C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);


        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        String player1Message = "Player 3 Turn";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }

    @Test
    @DisplayName("Player 1 plays a 2,player 2  plays 2 cards immediately and finished hand")
    public void acceptanceTestLine73() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "2C,3H";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4C,6C";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);

        //rigging player 3 & 4 hands so there will be no winner
        String Player3HandRigged = "8C";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player3HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        String Player4HandRigged = "9C";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);



        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "2C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Plays a card
        String Player2CardPlayed = "4C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 Plays a card
        Player2CardPlayed = "6C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);


        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        String player1Message = "No Winner yet";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }

    @Test
    @DisplayName("Player 2 plays a card and ends the round and ends the game")
    public void acceptanceTestLine77() {
        WebDriver hostBrowser;
        WebDriver player2Browser;
        WebDriver player3Browser;
        WebDriver player4Browser;
        WebDriver riggingBrowser;

        System.setProperty(webDriverType, webDriverLocation);
        hostBrowser = new ChromeDriver();
        hostBrowser.get("http://localhost:8080");

        //Player 1/Host starting and Joining the game
        hostBrowser.findElement(By.id("hostButton")).sendKeys(Keys.ENTER);
        hostBrowser.findElement(By.id("startGameButton")).sendKeys(Keys.ENTER);

        //Player 2 joining the Game
        player2Browser = new ChromeDriver();
        player2Browser.get("http://localhost:8080");
        player2Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player2Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 3 Joining the Game
        player3Browser = new ChromeDriver();
        player3Browser.get("http://localhost:8080");
        player3Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player3Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Player 4 Joining the Game
        player4Browser = new ChromeDriver();
        player4Browser.get("http://localhost:8080");
        player4Browser.findElement(By.id("joinGameButton")).sendKeys(Keys.ENTER);
        player4Browser.findElement(By.id("continueButton")).sendKeys(Keys.ENTER);

        //Sleep for 3 seconds
        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg the player 1's cards
        riggingBrowser = new ChromeDriver();
        riggingBrowser.get("http://localhost:8080/riggingPage");
        String DiscardPile = "7C";
        String Player1HandRigged = "3C,AS";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4C";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        String Player3HandRigged = "8H,JH,6H,KH,KS";
        riggingBrowser.findElement(By.id("Player3HandText")).sendKeys(Player3HandRigged);
        riggingBrowser.findElement(By.id("Player3HandButton")).sendKeys(Keys.ENTER);
        String Player4HandRigged = "8C,8D,2D";
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        String Player1CardPlayed = "3C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        String Player2CardPlayed = "4C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);


        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        //String player1Message = "Player 1 Score: 10. Player 2 Score: 0. Player 3 Score: 44. Player 4 Score: 18";
        String player1Message = "Player 1 Score: 1. Player 2 Score: 0. Player 3 Score: 86. Player 4 Score: 102";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }





}
