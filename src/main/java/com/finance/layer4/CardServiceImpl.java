package com.finance.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dto.CardDto;
import com.finance.layer2.CardTable;
import com.finance.layer3.CardRepository;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardRepository crdRepo;
	
	public CardDto findCardDetails(long crdNo) { //dervice method as per business logic using DTO
		CardTable crd = crdRepo.findCard(crdNo);
		
		CardDto crddto = new CardDto();
		
		crddto.setCustName(crd.getCustName());
		crddto.setCardNo(crd.getCardNo());
		crddto.setCardLimit(crd.getCardLimit());
		crddto.setEndDate(crd.getEndDate());
		crddto.setStartDate(crd.getStartDate());
		
		crddto.setCardType(crd.getApprovalTable().getRegistrationTable().getCardType());
		return crddto;
	}

	@Override
	public void addCardService(CardTable crdRef) {
		// TODO Auto-generated method stub
		System.out.println("Card Service....Some scope of bussiness logic here...");
		crdRepo.addCard(crdRef);
	}

	@Override
	public CardTable findCardService(long crdNo) {
		System.out.println("Cardr Service....Some scope of bussiness logic here...");
		CardTable crd = crdRepo.findCard(crdNo);
		return crd;
	}

	@Override
	public Set<CardTable> findCardService() {
		System.out.println("Cardr Service....Some scope of bussiness logic here...");
		return crdRepo.findAllCards();

	}

	@Override
	public void modifyCardService(CardTable crdRef) {
		// TODO Auto-generated method stub
		CardTable crd = crdRepo.findCard(crdRef.getCardNo());
		crdRepo.modifyCard(crd);
	}

}
