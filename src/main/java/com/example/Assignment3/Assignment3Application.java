package com.example.Assignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
@RestController
public class Assignment3Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment3Application.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/host")
	public String player1Host() {
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("Created server Socket");
			server.accept();
			server.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return String.format("Welcome Player 1! Waiting for other players to join");
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
