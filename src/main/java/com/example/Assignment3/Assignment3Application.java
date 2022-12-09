package com.example.Assignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


@SpringBootApplication
//@RestController
@Controller
public class Assignment3Application {
	gameHostBackEnd webHost;
	HostController hostcontroller;
	int count = 0;

	public static void main(String[] args) {
		SpringApplication.run(Assignment3Application.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@CrossOrigin
	@RequestMapping("/host")
	public String player1Host(Model model) {

		//Object for player 1 with that players hands is displayed on screen
		//Maybe Object for hands in the discard pile and displaying discard pile on screen

		model.addAttribute("numPlayers", webHost.getNumOfPlayersRemaining());
		model.addAttribute("allPlayerMessage", webHost.getAllPlayersOutput());


		if(webHost.gameHost != null) {
			model.addAttribute("PlayerHand", webHost.getPlayerHand(1));
			model.addAttribute("turnOrderDirection", webHost.getTurnOrderDirection());
			model.addAttribute("scoreBoardText", webHost.gameHost.printScoreBoardInLine());
		}


		//return String.format("Welcome Player 1! Waiting for other players to join");
		return "hostPage.html";
	}

	@RequestMapping("/waitingPlayers")
	public String player1HostWaitingPlayers(Model model, @ModelAttribute("numOfPlayers") int numPlayer) {



		webHost = new gameHostBackEnd(numPlayer);
		hostcontroller = new HostController();
		hostcontroller.setgameHostBackEnd(webHost);
		model.addAttribute("numPlayers", numPlayer);

		return "hostWaitingPlayersPage.html";

	}

	@RequestMapping("/confirmingPlayer")
	public String joiningPlayers(Model model) {
		/*
		try {
			Socket client = new Socket("localhost", 12345);
			System.out.println("Created Client Socket");

			client.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		 */
		int playerNumber = webHost.joinGame();

		model.addAttribute("playerNumberTitle", playerNumber);
		model.addAttribute("playerNumberBody", playerNumber);
		model.addAttribute("playerNumberInput", playerNumber);


		return "PlayerConfirmingPage.html";
	}

	@RequestMapping("/player")
	public String PlayerPage(Model model, @ModelAttribute("playersNumber") String playerNum) {
		/*
		try {
			Socket client = new Socket("localhost", 12345);
			System.out.println("Created Client Socket");

			client.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		 */

		model.addAttribute("playerNumberTitle", playerNum);
		model.addAttribute("playerNumberBody", playerNum);
		model.addAttribute("allPlayerMessage", webHost.getAllPlayersOutput());
		model.addAttribute("hiddenPlayerNum", playerNum);
		model.addAttribute("hiddenPlayerNum2", playerNum);
		if(webHost.gameHost != null) {
			int playerNumInt = Integer.valueOf(playerNum);
			model.addAttribute("PlayerHand", webHost.getPlayerHand(playerNumInt));
			model.addAttribute("turnOrderDirection", webHost.getTurnOrderDirection());
			model.addAttribute("scoreBoardText", webHost.gameHost.printScoreBoardInLine());
		}


		return "playerPage.html";
	}

	@RequestMapping("/riggingPage")
	public String player1HostWaitingPlayers(Model model) {



		return "riggingPage.html";

	}

	@GetMapping(path = "/playerHandRiggeing/{playerNum}/{cards}")
	public String playerHandRigging(@PathVariable("playerNum") int playerNum, @PathVariable("cards") String cards) {

		System.out.println("Rigging Player " + playerNum + " hand to  " + cards + " card");
		webHost.riggPlayerHand(playerNum, cards);

		return "riggingPage.html";
	}
	@GetMapping(path = "/discardPileRiggeing/{card}")
	public String riggingDiscardPileCard(@PathVariable("card") String card) {

		int valid = webHost.riggDiscardPile(card);
		System.out.println("Rigging Discard Pile to  " + card + " card");

		return "riggingPage.html";
	}

	@GetMapping(path = "/hostPlaysCard/{card}/{suit}")
	public String player1PlayingCard(@PathVariable("card") String card, @PathVariable("suit") String suit) {

		System.out.println("Player 1 playing:  " + card + " With a suit of  " + suit);
		String playerInput = card + "," + suit;
		webHost.setPlayerOutput(1, playerInput);

		return "hostPage.html";
	}

	@GetMapping(path = "/PlayerPlaysCard/{playerNum}/{card}/{suit}")
	public String anyPlayerPlayingCard(@PathVariable("playerNum") int playerNum, @PathVariable("card") String card, @PathVariable("suit") String suit) {

		System.out.println("Player " + playerNum + ":  " + card + " With a suit of  " + suit);
		String playerInput = card + "," + suit;
		webHost.setPlayerOutput(playerNum, playerInput);
		//System.out.println("Rigging Player " + playerNum + " hand to  " + cards + " card");

		return "playerPage.html";
	}

	@GetMapping(path = "/drawCard/{playerNum}")
	public String playerDrawingCard(@PathVariable("playerNum") int playerNum) {

		webHost.playerDrawCard(playerNum);
		System.out.println("Player " + playerNum + " drawing a card");

		if(playerNum == 1){
			return "hostPage.html";
		} else {
			return "playerPage.html";
		}
	}

	@GetMapping(path = "/lastDrawnCardRigging/{card}")
	public String lastDrawnCardRigging(@PathVariable("card") String card) {

		webHost.setLastDrawnCard(card);
		System.out.println("Player " + card + " drawing a card");

		return "riggingPage.html";
	}


}
