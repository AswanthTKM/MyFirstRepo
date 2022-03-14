package com.cts.repository;

//Repository for Admin

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
   //Repository method for getting Admin by Admin username and admin password
	
	public Admin findByAuserNameAndApassword(String auserName, String apassword);

}
