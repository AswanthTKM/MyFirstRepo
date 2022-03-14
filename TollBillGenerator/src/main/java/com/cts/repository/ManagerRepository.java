package com.cts.repository;

//Repository for Manager
import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    
	//Repository method for finding Manager by using Manager username and Manager Password
	
	public Manager findByMuserNameAndMpassword(String muserName, String mpassword);

}
