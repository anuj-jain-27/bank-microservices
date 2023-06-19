/**
 * 
 */
package com.eazybytes.cards.controller;

import com.eazybytes.cards.CardsConfig;
import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.eazybytes.cards.model.Properties;
import com.eazybytes.cards.repository.CardsRepository;
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
public class CardsController {

	@Autowired
	private CardsRepository cardsRepository;

	@Autowired
	CardsConfig config;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
		if (cards != null) {
			return cards;
		} else {
			return null;
		}
	}

	@GetMapping("cards-config")
	public Properties getConfigProperties() throws JsonProcessingException {
		Properties properties=new Properties(config.getMsg(),config.getBuildVersion(),config.getMailDetails(),config.getActiveBranches());
		return properties;
	}

}
