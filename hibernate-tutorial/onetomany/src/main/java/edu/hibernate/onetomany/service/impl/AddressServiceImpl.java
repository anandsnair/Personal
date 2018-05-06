package edu.hibernate.onetomany.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hibernate.onetomany.model.Address;
import edu.hibernate.onetomany.model.User;
import edu.hibernate.onetomany.repository.AddressRepository;
import edu.hibernate.onetomany.repository.UserRepository;
import edu.hibernate.onetomany.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addrRepo;
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Address createAddress(Address address, String userId) {
		Optional<User> user = userRepo.findById(userId);
		address.setUser(user.get());
		return addrRepo.save(address);
	}

	@Override
	public Address getAddressById(String addrId) {
		return addrRepo.getOne(addrId);
	}
	

}
