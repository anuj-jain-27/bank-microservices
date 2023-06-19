/**
 * 
 */
package com.eazybytes.loans.controller;

import com.eazybytes.loans.LoansConfig;
import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.model.Properties;
import com.eazybytes.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class LoansController {

	@Autowired
	private LoansRepository loansRepository;

	@Autowired
	LoansConfig config;

	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestBody Customer customer) {
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		} else {
			return null;
		}
	}

	@GetMapping("/loans-config")
	public Properties getConfigProperties() throws JsonProcessingException {
		Properties properties=new Properties(config.getMsg(),config.getBuildVersion(),config.getMailDetails(),config.getActiveBranches());
		return properties;
	}

}
