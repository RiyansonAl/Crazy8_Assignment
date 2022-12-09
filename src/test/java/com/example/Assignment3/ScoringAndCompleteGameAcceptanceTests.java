package com.example.Assignment3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoringAndCompleteGameAcceptanceTests {

    String webDriverLocation = "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\chromedriver.exe";
    String webDriverType = "webdriver.chrome.driver";


    @Test
    @DisplayName("Complete game testing")
    public void acceptanceTestLine80() {
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
        String DiscardPile = "4D";
        String Player1HandRigged = "4H,7S,5D,6D,9D";
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        String Player2HandRigged = "4S,6S,KC,8H,10D";
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        String Player3HandRigged = "9S,6C,9C,JD,3H";
        riggingBrowser.findElement(By.id("Player3HandText")).sendKeys(Player3HandRigged);
        riggingBrowser.findElement(By.id("Player3HandButton")).sendKeys(Keys.ENTER);
        String Player4HandRigged = "7D,JH,QH,KH,5C";
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);

        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 1 plays a card
        String Player1CardPlayed = "4H";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        String Player2CardPlayed = "4S";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        String Player3CardPlayed = "9S";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 Draws a card
        player4Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player4HandRigged = "7D,JH,QH,KH,5C,2C";
        String lastDrawnCard = "2C";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 draws another card
        player4Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player4HandRigged = "7D,JH,QH,KH,5C,2C,3C";
        lastDrawnCard = "3C";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 draws a third card
        player4Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player4HandRigged = "7D,JH,QH,KH,5C,2C,3C,4C";
        lastDrawnCard = "4C";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        Player1CardPlayed = "7S";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "6S";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "6C";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        String Player4CardPlayed = "2C";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg Player 1's hand
        Player1HandRigged = "5D,6D,9D,10C,JC";
        riggingBrowser.findElement(By.id("Player1HandText")).clear();
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        Player1CardPlayed = "JC";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "KC";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "9C";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        Player4CardPlayed = "3C";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 draws a card
        hostBrowser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 1's hand
        Player1HandRigged = "5D,6D,9D,10C,7C";
        lastDrawnCard = "7C";
        riggingBrowser.findElement(By.id("Player1HandText")).clear();
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //up to line 101
        //Player 1 plays a card
        Player1CardPlayed = "7C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "8H";
        String suitChosen = "D";
        player2Browser.findElement(By.id("playerSuitField")).clear();
        player2Browser.findElement(By.id("playerSuitField")).sendKeys(suitChosen);
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "JD";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        Player4CardPlayed = "7D";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        Player1CardPlayed = "9D";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "10D";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Ending Round 1 after this card (Line 107)
        //Assert the score at the end of the round
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        //String player1Message = "Player 1 Score: 1. Player 2 Score: 0. Player 3 Score: 86. Player 4 Score: 102";
        String player1Message = "Player 1 Score: 21. Player 2 Score: 0. Player 3 Score: 3. Player 4 Score: 39";
        assertTrue((player1Text.getText().contains(player1Message)));

        //Sleeping for 15 seconds waiting for the new round to start
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }





        //rigging the hands for the new round
        DiscardPile = "10D";
        Player1HandRigged = "7D,4S,7C,4H,5D";
        riggingBrowser.findElement(By.id("discardPileText")).clear();
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(DiscardPile);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player1HandText")).clear();
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        Player2HandRigged = "9D,3S,9C,3H,JC";
        riggingBrowser.findElement(By.id("Player2HandText")).clear();
        riggingBrowser.findElement(By.id("Player2HandText")).sendKeys(Player2HandRigged);
        riggingBrowser.findElement(By.id("Player2HandButton")).sendKeys(Keys.ENTER);
        Player3HandRigged = "3D,9S,3C,9H,5H";
        riggingBrowser.findElement(By.id("Player3HandText")).clear();
        riggingBrowser.findElement(By.id("Player3HandText")).sendKeys(Player3HandRigged);
        riggingBrowser.findElement(By.id("Player3HandButton")).sendKeys(Keys.ENTER);
        Player4HandRigged = "4D,7S,4C,5S,8D";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        //Sleep 5 seconds waiting for the new round to start
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 2 plays a card
        Player2CardPlayed = "9D";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "3D";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        Player4CardPlayed = "4D";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        Player1CardPlayed = "4S";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "3S";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "9S";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        Player4CardPlayed = "7S";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        Player1CardPlayed = "7C";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "9C";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "3C";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        Player4CardPlayed = "4C";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 plays a card
        Player1CardPlayed = "4H";
        hostBrowser.findElement(By.id("playerCardField")).sendKeys(Player1CardPlayed);
        hostBrowser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 plays a card
        Player2CardPlayed = "3H";
        player2Browser.findElement(By.id("playerCardField")).sendKeys(Player2CardPlayed);
        player2Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 3 plays a card
        Player3CardPlayed = "9H";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 draws
        //Player 4 Draws a card
        player4Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player4HandRigged = "5S,8D,KS";
        lastDrawnCard = "KS";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 draws another card
        player4Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player4HandRigged = "5S,8D,KS,QS";
        lastDrawnCard = "QS";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 draws a third card
        player4Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player4HandRigged = "5S,8D,KS,QS,KH";
        lastDrawnCard = "KH";
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 4 plays a card
        Player4CardPlayed = "KH";
        player4Browser.findElement(By.id("playerCardField")).sendKeys(Player4CardPlayed);
        player4Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //The current rigging system does not rig fast enough to detect the last card is playable
        //We will need to manually reset the cards here
        //Rigg player 4's hand
        Player4HandRigged = "5S,8D,KS,QS";
        lastDrawnCard = "KH";
        riggingBrowser.findElement(By.id("discardPileText")).clear();
        riggingBrowser.findElement(By.id("discardPileText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("discardPileButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("Player4HandText")).clear();
        riggingBrowser.findElement(By.id("Player4HandText")).sendKeys(Player4HandRigged);
        riggingBrowser.findElement(By.id("Player4HandButton")).sendKeys(Keys.ENTER);


        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 1 draws
        //Player 1 Draws a card
        hostBrowser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 1's hand
        Player1HandRigged = "7D,5D,6D";
        lastDrawnCard = "6D";
        riggingBrowser.findElement(By.id("Player1HandText")).clear();
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 draws another card
        hostBrowser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 1's hand
        Player1HandRigged = "7D,5D,6D,QD";
        lastDrawnCard = "QD";
        riggingBrowser.findElement(By.id("Player1HandText")).clear();
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Player 1 draws a third card
        hostBrowser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 1's hand
        Player1HandRigged = "7D,5D,6D,QD,JD";
        lastDrawnCard = "JD";
        riggingBrowser.findElement(By.id("Player1HandText")).clear();
        riggingBrowser.findElement(By.id("Player1HandText")).sendKeys(Player1HandRigged);
        riggingBrowser.findElement(By.id("Player1HandButton")).sendKeys(Keys.ENTER);
        riggingBrowser.findElement(By.id("LastDrawnCardText")).clear();
        riggingBrowser.findElement(By.id("LastDrawnCardText")).sendKeys(lastDrawnCard);
        riggingBrowser.findElement(By.id("LastDrawnCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        //Player 2 Draws
        //Player 2 Draws a card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 2's hand
        Player2HandRigged = "JC,6S";
        lastDrawnCard = "6S";
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

        //Player 2 draws another card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player2HandRigged = "JC,6S,JS";
        lastDrawnCard = "JS";
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

        //Player 2 draws a third card
        player2Browser.findElement(By.id("drawCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Rigg player 4's hand
        Player2HandRigged = "JC,6S,JS,10S";
        lastDrawnCard = "10S";
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

        //Player 3's turn
        //Player 3 plays a card
        Player3CardPlayed = "5H";
        player3Browser.findElement(By.id("playerCardField")).sendKeys(Player3CardPlayed);
        player3Browser.findElement(By.id("playerCardButton")).sendKeys(Keys.ENTER);
        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }




        //Sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }






        //Sleep for 10 seconds to allow all the pages to refresh
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        //Ending Round 1 after this card (Line 107)
        //Assert the score at the end of the round
        player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        //String player1Message = "Player 1 Score: 1. Player 2 Score: 0. Player 3 Score: 86. Player 4 Score: 102";
        player1Message = "Player 1 Score: 59. Player 2 Score: 36. Player 3 Score: 3. Player 4 Score: 114";
        assertTrue((player1Text.getText().contains(player1Message)));

        /*
        //Check the card was played
        WebElement player1Text = hostBrowser.findElement(By.xpath("//*[text() != '']"));
        //String player1Message = "Player 1 Score: 1. Player 2 Score: 0. Player 3 Score: 86. Player 4 Score: 102";
        String player1Message = "Player 1 Turn";
        System.out.println(player1Text.getText());
        assertTrue((player1Text.getText().contains(player1Message)));

         */


        riggingBrowser.quit();
        player2Browser.quit();
        player3Browser.quit();
        player4Browser.quit();
        hostBrowser.quit();

    }



}
