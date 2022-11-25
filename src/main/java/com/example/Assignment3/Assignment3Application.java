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
	Player1Host webHost;
	int count = 0;

	public static void main(String[] args) {
		SpringApplication.run(Assignment3Application.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@RequestMapping("/host")
	public String player1Host(Model model, @ModelAttribute("numOfPlayers") int numPlayer) {
		//Init the webhost
		//int numPlayer = 3;
		webHost = new Player1Host(numPlayer);
		//Object for player 1 with that players hands is displayed on screen
		//Maybe Object for hands in the discard pile and displaying dicard pile on screen

		//model.addAttribute("serverTime", dateFormat.format(new Date()));
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		model.addAttribute("serverTime", formattedDate);

		model.addAttribute("numPlayers", webHost.getNumOfPlayers());
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
	public String player1HostWaitingPlayers(Model model) {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		model.addAttribute("serverTime", formattedDate);
		
		webHost.setNumOfPlayers(webHost.getNumOfPlayers() -1);
		model.addAttribute("numPlayers", webHost.getNumOfPlayers());

		return "hostWaitingPlayersPage.html";

	}

	@GetMapping("/player")
	public String joiningPlayers() {
		try {
			Socket client = new Socket("localhost", 12345);
			System.out.println("Created Client Socket");

			client.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return String.format("Welcome Player!");
	}


}
