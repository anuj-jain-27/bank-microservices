package com.eazybytes.accounts.clientservice;

import com.eazybytes.accounts.model.Cards;
import com.eazybytes.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("cards")
public interface CardsClient {

    @RequestMapping(method = RequestMethod.POST,value = "myCards",consumes = "application/json")
    List<Cards> getCards(@RequestBody Customer customer);
}
