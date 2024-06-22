package com.BankingApplication.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.entity.Account;
import com.BankingApplication.mapper.AccountMapper;
import com.BankingApplication.service.AccountService;
import com.BankingApplication.repository.AcoountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	
	private AcoountRepository accountRepository;
	
	//Constructor Injection
	public AccountServiceImpl(AcoountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		//First Controller send request to create account the data is send to 
		//AccountDto then we convrt the AccountDto data to Account using mapper
		//then the account data is stored in repo
		//once evrything is done we need to return that the account is created 
		//but we will not send the account data directly from account
		//instead we will convert the account data to accountDto then
		//the accountDto data is send to postman
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow();
		
			return AccountMapper.mapToAccountDto(account);
		
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
	
		Account account = accountRepository.findById(id).orElseThrow();

		double totalBalance = account.getBalance()+ amount;
		account.setBalance(totalBalance);
	
		Account savedAccount = accountRepository.save(account);
	
			return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow();
		
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		
		else {
			double totalBalance = account.getBalance() - amount;
			account.setBalance(totalBalance);
			
			Account savedAccount = accountRepository.save(account);
			
			return AccountMapper.mapToAccountDto(savedAccount);
		}
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		
		ArrayList<AccountDto> accountDtos = new ArrayList<AccountDto>();
	    List<Account> accounts = accountRepository.findAll();

	    for (Account account : accounts) {
	        AccountDto accountDto = AccountMapper.mapToAccountDto(account);
	        accountDtos.add(accountDto);
	    }

	    return accountDtos;
		
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow();
		accountRepository.delete(account);

	}
}
