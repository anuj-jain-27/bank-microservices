/**
 * 
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.AccountsConfig;
import com.eazybytes.accounts.clientservice.CardsClient;
import com.eazybytes.accounts.clientservice.LoansClient;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.AccountsRes;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Properties;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	AccountsConfig config;

	@Autowired
	LoansClient loanClient;

	@Autowired
	CardsClient cardsClient;

	@PostMapping(" ")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}
	}

	@PostMapping("user-details")
	public AccountsRes getUserDetails(@RequestBody Customer customer) {
		AccountsRes accDetails = new AccountsRes();
		accDetails.setCards(cardsClient.getCards(customer));
		accDetails.setLoans(loanClient.getLoans(customer));
		accDetails.setAccounts(accountsRepository.findByCustomerId(customer.getCustomerId()));
		return accDetails;
	}

	@GetMapping("accounts-config")
	public Properties getConfigProperties() throws JsonProcessingException {
		Properties properties=new Properties(config.getMsg(),config.getBuildVersion(),config.getMailDetails(),config.getActiveBranches());
		return properties;
	}

}
