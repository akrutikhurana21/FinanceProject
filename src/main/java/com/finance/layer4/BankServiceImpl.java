package com.finance.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.layer2.BankTable;
import com.finance.layer2.OrderTable;
import com.finance.layer3.BankRepository;
import com.finance.layer3.OrderRepository;

@Service
public class BankServiceImpl  implements BankService {

	@Autowired
	BankRepository bankRepo;
	
	@Override
	public void addBankService(BankTable bankRef) {
		// TODO Auto-generated method stub
		System.out.println("Bank Service....Some scope of bussiness logic here...");
		bankRepo.addBank(bankRef);

	}

	@Override
	public BankTable findBankService(long bankAcc) {
		// TODO Auto-generated method stub
		System.out.println("Order Service....Some scope of bussiness logic here...");
		BankTable bank = bankRepo.findBank(bankAcc);
		return bank;
	}

	@Override
	public Set<BankTable> findAllBanksService() {
		// TODO Auto-generated method stub
		//ordRepo.findAllOrders();
		return bankRepo.findAllBanks();
	}

	@Override
	public void modifyBankService(BankTable bankRef) {
		// TODO Auto-generated method stub
		BankTable bank = bankRepo.findBank(bankRef.getAccountNo());
		bankRepo.modifyBank(bankRef);
	}
		
	

	}


