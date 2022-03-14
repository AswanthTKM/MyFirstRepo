package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Admin;
import com.cts.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository arepo;

	/*
	 * public boolean validateAdmin(String email, String password) { //
	 * admin@gmail.com and admin return
	 * (email.equals("admin@gmail.com")||email.equals("admin")) &&
	 * password.equals("admin"); }
	 */

	public boolean validateAdmin(String auserName, String apassword) {
		Admin admin = arepo.findByAuserNameAndApassword(auserName, apassword);
		if (admin == null) {
			return false;
		} else {
			return true;
		}
	}

}
