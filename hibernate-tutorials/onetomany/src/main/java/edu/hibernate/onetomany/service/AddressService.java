package edu.hibernate.onetomany.service;

import edu.hibernate.onetomany.model.Address;

public interface AddressService {

	public Address createAddress(Address address, String userId);
	public Address getAddressById(String addrId);
}
