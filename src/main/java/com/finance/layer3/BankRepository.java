package com.finance.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.BankTable;

@Repository
public interface BankRepository {
	
	void addBank(BankTable bRef );   //C - add/create
	
	BankTable findBank(long accountNo);     //R - find/reading
	
	Set<BankTable> findAllBanks();     //R - find all/reading all
	
	void modifyBank(BankTable bRef); //U - modify/update
	
	void removeBank(long accountNo); //D - remove/delete

}
