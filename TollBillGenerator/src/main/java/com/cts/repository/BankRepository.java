package com.cts.repository;

//Repository for Bank details

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.BankDetails;

public interface BankRepository extends JpaRepository<BankDetails, Integer> {
     
	
	//repository method for getting bank details by bank username and bank password
	
	public BankDetails findByBuserNameAndBpassword(String buserName, String bpassword);

}
