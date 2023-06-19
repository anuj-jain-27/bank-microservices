package com.eazybytes.accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountsRes {
    Accounts accounts;
    List<Loans> loans;
    List<Cards> cards;
}
