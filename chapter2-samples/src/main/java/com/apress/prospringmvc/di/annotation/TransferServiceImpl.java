package com.apress.prospringmvc.di.annotation;

import java.math.BigDecimal;

import javax.inject.Inject;

import com.apress.prospringmvc.Account;
import com.apress.prospringmvc.AccountService;
import com.apress.prospringmvc.TransferService;

public class TransferServiceImpl implements TransferService {

	@Inject
	private AccountService accountService;

	public TransferServiceImpl() {
		super();
	}

	@Override
	public void transfer(final Account from, final Account to,
			final BigDecimal amount) {
	}

}