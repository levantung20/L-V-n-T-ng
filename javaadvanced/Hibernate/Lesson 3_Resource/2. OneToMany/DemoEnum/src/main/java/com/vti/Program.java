package com.vti;

import java.util.List;

import com.vti.entity.Address;
import com.vti.entity.User;
import com.vti.repository.UserRepository;

public class Program {
	public static void main(String[] args) {
		UserRepository userRepository = new UserRepository();

		System.out.println("***********GET ALL USERS***********");

		List<User> users = userRepository.getAllUsers();

		for (User user : users) {
			System.out.println("User: " + user.getUsername());
			for (Address address : user.getAddresses()) {
				System.out.println("Address: " + address.getStreet() + " - " + address.getCity());
			}
			System.out.println("");
		}
	}
}







