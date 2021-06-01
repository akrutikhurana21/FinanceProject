package com.finance.layer4;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.finance.layer2.RegistrationTable;
import com.finance.layer4.exceptions.AlreadyRegisteredException;
//import com.example.demo.layer4.exceptions.DepartmentAlreadyExistsException;
//import com.example.demo.layer4.exceptions.DepartmentNotFoundException;
@Service
public interface RegistrationService {
	
	
	void addRegistrationService(RegistrationTable rRef );   //C - add/create
	
	RegistrationTable findRegistrationService(long regId);     //R - find/reading
	
	Set<RegistrationTable> findAllRegistrationsService();     //R - find all/reading all
	
	void modifyRegistrationService(RegistrationTable rRef); //U - modify/update
	
	
}

