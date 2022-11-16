package com.example.Assignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	public static void main(String[] args) {
		SpringApplication.run(Assignment3Application.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@RequestMapping("/host")
	public String player1Host(Model model) {

		//model.addAttribute("serverTime", dateFormat.format(new Date()));
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		model.addAttribute("serverTime", formattedDate);

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
