package com.finance.layer4;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.layer2.RegistrationTable;
import com.finance.layer3.RegistrationRepository;
import com.finance.layer4.exceptions.AlreadyRegisteredException;

@Service
public class RegistrationServiceImpl implements RegistrationService {
		
	@Autowired
	RegistrationRepository regRepo;
	
	
	public void addRegistrationService(RegistrationTable regRef)  {
		System.out.println("Registration Service....Some scope of bussiness logic here...");
			
				regRepo.addRegistration(regRef);
		}

	public RegistrationTable findRegistrationService(long regId){
		System.out.println("Registration  Service....Some scope of bussiness logic here...");
		return regRepo.findRegistration(regId);
	}

	public Set<RegistrationTable> findAllRegistrationsService() {
		System.out.println("Registration  Service....Some scope of bussiness logic here...");
		return regRepo.findAllRegistrations();
	}

	
	public void modifyRegistrationService(RegistrationTable regRef) {
		System.out.println("Registration  Service....Some scope of bussiness logic here...");
		
		RegistrationTable regtabl =regRepo.findRegistration(regRef.getRegId());
	
		regRepo.modifyRegistration(regtabl);
	}

}

