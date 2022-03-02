package com.vti;

import java.util.List;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;

public class Program {
	public static void main(String[] args) {
		AddressRepository addressRepository = new AddressRepository();

		System.out.println("***********GET ALL ADDRESSES***********");

		List<Address> addresses = addressRepository.getAllAddresses();

		for (Address address : addresses) {
			System.out.println("Address: " + address.getStreet() + " - " + address.getCity());
			System.out.println("User: " + address.getUser().getUsername());
			System.out.println("");
		}
	}
}
