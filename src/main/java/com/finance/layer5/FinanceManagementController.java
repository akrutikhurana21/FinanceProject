package com.finance.layer5;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dto.LoginDto;
import com.finance.layer4.LoginService;

@CrossOrigin(origins="http://localhost:4200")
@RestController  //REpresentational State Transfer html xml json
public class FinanceManagementController {
	
	@Autowired
	LoginService logServ;
	
	
	@PostMapping(path="/getLogin")
	@ResponseBody
	 public LoginDto addCard(@RequestBody LoginDto upass) {
		 System.out.println("Login controller Understanding client ");
		 LoginDto ldObj = logServ.getLoginInfo(upass);
		 return ldObj;
	 }
	   
	}
	 