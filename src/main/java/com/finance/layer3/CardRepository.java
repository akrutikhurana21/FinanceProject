package com.finance.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.CardTable;

@Repository
public interface CardRepository {
	void addCard(CardTable cRef);   //C - add/create
	CardTable findCard(long cardNo);     //R - find/reading
	Set<CardTable> findAllCards();     //R - find all/reading all
	void modifyCard(CardTable cRef); //U - modify/update
	void removeCard(long cardNo); //D - remove/delete
}