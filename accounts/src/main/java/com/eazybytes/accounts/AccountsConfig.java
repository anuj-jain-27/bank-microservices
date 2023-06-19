package com.eazybytes.accounts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="accounts")
@Getter
@Setter
@ToString
public class AccountsConfig {
    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
    private List<String> activeBranches;
}
/*
the above class maps to these properties wherever - comes its is replaced by camel case by springboot.
@ConfigurationProperties prefix flag tells us what properties we have to pick up i.e. the properties after account. .
if we have more prefixes in the config file we can read it by creating other similar classes with @ConfigurationProperties annotation

accounts.msg =Welcome to the EazyBank Accounts Dev application
accounts.build-version=2

accounts.mailDetails.hostName=dev-accounts@eazybytes.com
accounts.mailDetails.port=9020
accounts.mailDetails.from=dev-accounts@eazybytes.com
accounts.mailDetails.subject=Your Account Details from Eazy Bank Dev Environment

accounts.activeBranches[0]=Chennai
accounts.activeBranches[1]=Berlin
accounts.activeBranches[2]=Indianapollis
 */