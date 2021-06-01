package com.finance.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dto.LoginDto;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.RegistrationRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	RegistrationRepository regRepo;
	
	
	
	public LoginServiceImpl() {
	}
	public LoginDto getLoginInfo(LoginDto ldObj) {
		
		Set<RegistrationTable> regSet = regRepo.findAllRegistrations();
				for(RegistrationTable rt: regSet) {
					if((rt.getUsername().compareTo(ldObj.getUsername()) == 0) 
							&& (rt.getPassword().compareTo(ldObj.getPassword()) == 0)) {
						ldObj.setCardNo(rt.getApprovalTable().getCardTable().getCardNo());
						System.out.println("Login Successfull");
						break;
					}
				}
		
		return ldObj;
	}

}
