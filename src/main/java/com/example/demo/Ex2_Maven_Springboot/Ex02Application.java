package com.example.demo.Ex2_Maven_Springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Ex02Application implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Ex02Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("What your name?");
		String name=null;
		if (scanner.hasNext()) {
			name = scanner.nextLine();
		}
		new Redict(name);
		return;
	}
}
