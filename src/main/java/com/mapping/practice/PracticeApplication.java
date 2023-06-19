package com.mapping.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapping.practice.Entities.UserDetails;
import com.mapping.practice.Entities.UserSettings;
import com.mapping.practice.repository.UserDetailsRepository;
//SpringBootApplication class
@SpringBootApplication
public class PracticeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public void run(String... args) throws Exception {
		UserDetails userDetails = new UserDetails( "Rameshwar", "Pawar", "rameshwar@123gmail.com");

		UserSettings userSettings = new UserSettings( "Cricket Playing");

		userDetails.setUserSettings(userSettings);

		userDetailsRepository.save(userDetails);
	}
}
