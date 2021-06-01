package com.finance.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.finance.layer2.BankTable;

@Service
public interface BankService {
	 void addBankService(BankTable bankRef) ;   //C - add/create
	BankTable findBankService(long bankAcc);     //R - find/reading
	Set<BankTable> findAllBanksService();     //R - find all/reading all
	void modifyBankService(BankTable bankRef); //U - modify/update
	//String removeBankService(long ordId); //D - remove/delete
}
