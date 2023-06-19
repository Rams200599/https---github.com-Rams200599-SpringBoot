package com.mapping.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mapping.practice.Entities.UserDetails;
import com.mapping.practice.Entities.UserSettings;
import com.mapping.practice.repository.UserDetailsRepository;
import com.mapping.practice.repository.UserSettingsRepository;
//Test cases
@SpringBootTest
// @AutoConfigureTestDatabase
class PracticeApplicationTests {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private UserSettingsRepository userSettingsRepository;

	//Test cases for create new user details
	@Test
	@Order(1)
	public void testCreateUser(){
		UserDetails userDetails = new UserDetails();
		userDetails.setId((long) 2);
		userDetails.setFirstName("Vaibhav");
		userDetails.setLastName("Kulkarni");
		userDetails.setEmail("vaibhav@123gmail.com");

		UserSettings  userSettings = new UserSettings();
		userSettings.setHobby("Kho-Kho Playing");
		userDetails.setUserSettings(userSettings);

		// userSettings.setId(userDetails.getId());

		userDetailsRepository.save(userDetails);
		// assertNotNull(userDetailsRepository.findById((long) 2).get());
	}

	//Test case for get all user details
	@Test
	@Order(2)
	public void testGetAllUser(){
		List<UserDetails> list = userDetailsRepository.findAll();
		System.out.println(list);
	}

	//Test case for get single user details.
	@Test
	@Order(3)
	public void testSingleUser(){
		UserDetails userDetails = userDetailsRepository.findById((long) 1).get();
		UserSettings userSettings = userSettingsRepository.findById((long) 1).get();
		// assertEquals("Ankit", userDetails.getFirstName());
		// assertEquals("Vollyball Playing", userSettings.getHobby());
	}

	//Test case for update user details.
	@Test
	@Order(4)
	public void testUpdateUser(){
		UserDetails userDetails = userDetailsRepository.findById((long) 1).get();
		userDetails.setFirstName("Ankit");
		userDetails.setLastName("More");
		userDetails.setEmail("ankitmore255@gmail.com");
		userDetailsRepository.save(userDetails);

		UserSettings userSettings = userSettingsRepository.findById((long) 1).get();
		userSettings.setHobby("Vollyball Playing");
		userSettingsRepository.save(userSettings);

		assertNotNull("Rameshwar", userDetailsRepository.findById((long) 1).get().getFirstName());
	}

	//Test case for delete user details by id.
	// @Test
	// @Order(5)
	// public void testDeleteUser(){
	// 	userDetailsRepository.deleteById((long) 6203);
	// }
}
