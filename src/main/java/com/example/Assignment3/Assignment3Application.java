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
		//Maybe Object for hands in the discard pile and displaying dicard pile on screen

		model.addAttribute("numPlayers", webHost.getNumOfPlayersRemaining());
		model.addAttribute("allPlayerMessage", webHost.getAllPlayersOutput());
		if(webHost.gameHost != null) {
			model.addAttribute("PlayerHand", webHost.getPlayerHand(1));
		}

		//model.addAttribute("serverTime", dateFormat.format(new Date()));
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		model.addAttribute("serverTime", formattedDate);

		count = count + 1;
		model.addAttribute("count", count);


		model.addAttribute("msgId", "Id");
		model.addAttribute("msgName", "Name");

		model.addAttribute("id", "Id here");
		model.addAttribute("name", "Name Here");

		/*
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("Created server Socket");
			server.accept();
			server.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		 */

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
		if(webHost.gameHost != null) {
			int playerNumInt = Integer.valueOf(playerNum);
			model.addAttribute("PlayerHand", webHost.getPlayerHand(playerNumInt));
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
		System.out.println("Rigging Player " + playerNum + " hand to  " + cards + " card");

		return "riggingPage.html";
	}
	@GetMapping(path = "/discardPileRiggeing/{card}")
	public String riggingDiscardPileCard(@PathVariable("card") String card) {

		webHost.riggDiscardPile(card);
		System.out.println("Rigging Discard Pile to  " + card + " card");

		return "riggingPage.html";
	}


}
