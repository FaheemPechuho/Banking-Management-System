package com.BankingApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}


	@PostMapping
	public AccountDto addAccount(@RequestBody AccountDto accountDto) {
	    try {
	        return accountService.createAccount(accountDto);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to create account", e);
	    }
	}

	@GetMapping("/{id}")
	public AccountDto getAccountById(@PathVariable Long id) {
	    try {
	        return accountService.getAccountById(id);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to get account with id: " + id, e);
	    }
	}

	@PutMapping("/{id}/deposit")
	public AccountDto deposit(@PathVariable Long id, @RequestBody double amount) {
	    try {
	        return accountService.deposit(id, amount);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to deposit amount: " + amount + " to account with id: " + id, e);
	    }
	}

	@PutMapping("/{id}/withdraw")
	public AccountDto withdraw(@PathVariable Long id, @RequestBody double amount) {
	    try {
	        return accountService.withdraw(id, amount);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to withdraw amount: " + amount + " from account with id: " + id, e);
	    }
	}
	
	@GetMapping
	public List<AccountDto> getAllAccounts(){
		try {
				List<AccountDto> accountDto = accountService.getAllAccounts();
				return accountDto;
		} catch (Exception e) {
			throw new RuntimeException("Failed to Get All Account");
		}
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable Long id) {
		 try {
	            accountService.deleteAccount(id);
	            return "Account with id: "+id+ " deleted Successfully";
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to delete account with id: " + id, e);
	        }
		
		
	}
	
	
	
	
}
