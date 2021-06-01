package com.finance.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.finance.dto.CardDto;
import com.finance.layer2.CardTable;

@Service
public interface CardService {
	 void addCardService(CardTable crdRef) ;   //C - add/create
	CardTable findCardService(long crdNo);     //R - find/reading
	Set<CardTable> findCardService();     //R - find all/reading all
	void modifyCardService(CardTable crdRef); //U - modify/update
	//String removeOrderService(long ordId); //D - remove/delete
	CardDto findCardDetails(long crdNo);
}
