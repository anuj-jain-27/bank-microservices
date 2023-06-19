package com.eazybytes.accounts.clientservice;

import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loans")
public interface LoansClient {
    @RequestMapping(method = RequestMethod.POST,value = "myLoans",consumes = "application/json")
    List<Loans> getLoans(@RequestBody Customer customer);
}
