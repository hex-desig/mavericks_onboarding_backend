package com.mavericks.onboarding.serivce;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavericks.onboarding.entity.Register;
import com.mavericks.onboarding.repo.RegisterRepo;


@Service
public class RegisterService {

	@Autowired
	RegisterRepo registerRepo;


	public Register registerUser(Register register) {
		register.setCreatedAt(Timestamp.from(Instant.now()));
		register.setUpdatedAt(Timestamp.from(Instant.now()));
		return registerRepo.save(register);
		
	}
	
	
	

}
