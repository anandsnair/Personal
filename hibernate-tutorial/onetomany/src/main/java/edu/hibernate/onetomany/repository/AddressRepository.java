package edu.hibernate.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hibernate.onetomany.model.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}
