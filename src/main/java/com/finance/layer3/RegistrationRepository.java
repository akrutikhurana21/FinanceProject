package com.finance.layer3;

import java.util.Set;


import org.springframework.stereotype.Repository;

import com.finance.layer2.RegistrationTable;
@Repository
public interface RegistrationRepository {
	
	
	void addRegistration(RegistrationTable rRef );   //C - add/create
	
	RegistrationTable findRegistration(long regId);     //R - find/reading
	
	Set<RegistrationTable> findAllRegistrations();     //R - find all/reading all
	
	void modifyRegistration(RegistrationTable dRef); //U - modify/update
	
	void removeRegistration(long regId); //D - remove/delete
}