package com.finance.layer5;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.layer2.RegistrationTable;
import com.finance.layer4.RegistrationService;
import com.finance.layer4.exceptions.AlreadyRegisteredException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController  //REpresentational State Transfer html xml json
public class RegistrationController {

	@Autowired
	RegistrationService regServ;
	
	@GetMapping(path="/getReg/{myregId}")
	@ResponseBody
	public ResponseEntity<RegistrationTable> getRegistration(@PathVariable("myregId") long regId) {
		System.out.println("Registration Controller....Understanding client and talking to service layer...");
		RegistrationTable regt=null;
		
			regt = regServ.findRegistrationService(regId);
			return ResponseEntity.ok(regt);
		
	}
	
	
	@GetMapping(path="/getRegs")
	@ResponseBody
	public Set<RegistrationTable> getAllRegistration() {
		System.out.println("Registration Controller....Understanding client and talking to service layer...");
		Set<RegistrationTable> regList = regServ.findAllRegistrationsService();
		return regList;
		
	}
	
	@PostMapping(path="/addReg")
	public RegistrationTable addRegistration(@RequestBody RegistrationTable regt) {
		System.out.println("Registration Controller....Understanding client and talking to service layer...");
		RegistrationTable reg=new RegistrationTable();
		reg.setName(regt.getName());
		reg.setAddress(regt.getAddress());
		reg.setAdharCard(regt.getAdharCard());
		reg.setCardType(regt.getCardType());
		reg.setDob(regt.getDob());
		reg.setEmailId(regt.getEmailId());
		reg.setPassword(regt.getPassword());
		reg.setPhoneNo(regt.getPhoneNo());
		reg.setRegistrationDate(regt.getRegistrationDate());
		reg.setUsername(regt.getUsername());
		regServ.addRegistrationService(reg); 
		System.out.println("Registration Done");
		return reg;
			
	}
	
//	@GetMapping(path="/getapprvOfRegt")
//	@ResponseBody
//	public Set<ApprovalTable> getAllapprvOfRegt() {
//		System.out.println("Department Controller....Understanding client and talking to service layer...");
//		RegistrationTable regt=null;
//	//	try {
//			regt = regServ.findRegistrationService(30);
//		//} catch (DepartmentNotFoundException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
//		Set<ApprovalTable> apprSet =regt.getAppSet();
//		return apprSet;
//		
//	}
	

//	
//	@PutMapping(path="/modifyDept")
//	public String modifyDepartment(@RequestBody Department5 dept) {
//		System.out.println("Department Controller....Understanding client and talking to service layer...");
//		Department5 d =new Department5();
//		d.setDepartmentNumber(dept.getDepartmentNumber());
//		d.setDepartmentName(dept.getDepartmentName());
//		d.setDepartmentLocation(dept.getDepartmentLocation());
//		 String stmsg = null;
//		try {
//			stmsg = deptServ.modifyDepartmentService(dept);
//		} 
//		catch (DepartmentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return e.getMessage();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		  return stmsg;
//		
//	}
//	
//	@DeleteMapping(path="/deleteDeptById/{mydno}")
//	@ResponseBody
//	public String deleteDepartment(@PathVariable("mydno")Integer dno){
//		System.out.println("Department Controller....Understanding client and talking to service layer...");
//		 String stmsg = null;
//		try {
//			stmsg = deptServ.removeDepartmentService(dno);
//		} 
//		catch (DepartmentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return e.getMessage();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		  return stmsg;
//		
//	}
//	
}


