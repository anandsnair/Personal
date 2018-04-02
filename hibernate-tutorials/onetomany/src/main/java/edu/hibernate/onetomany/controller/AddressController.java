package edu.hibernate.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hibernate.onetomany.model.Address;
import edu.hibernate.onetomany.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/address/{userId}")
	public Address createAddress(@RequestBody Address address, @PathVariable String userId) {
		return addressService.createAddress(address, userId);
	}
	
	@GetMapping("/address/{addrId}")
	public Address getAddressById(@PathVariable String addrId) {
		return addressService.getAddressById(addrId);
	}

}
