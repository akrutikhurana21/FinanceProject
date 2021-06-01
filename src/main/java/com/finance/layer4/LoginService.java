package com.finance.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.finance.dto.CardDto;
import com.finance.dto.LoginDto;
import com.finance.layer2.CardTable;

@Service
public interface LoginService {
	LoginDto getLoginInfo(LoginDto ldObj);
}
