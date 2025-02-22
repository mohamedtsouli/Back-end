package com.example.ebankbackend.services;

import com.example.ebankbackend.dtos.*;
import com.example.ebankbackend.entities.BankAccount;
import com.example.ebankbackend.entities.CurrentAccount;
import com.example.ebankbackend.entities.SavingAccount;
import com.example.ebankbackend.entities.customer;
import com.example.ebankbackend.exceptions.BalanceNotSufficientException;
import com.example.ebankbackend.exceptions.BankAccountNotFoundException;
import com.example.ebankbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {


     customerDTO saveCustomer(customerDTO customerDTO);

     CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
     SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
     List<customerDTO> listCustomers();
     BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
     void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
     void credit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
     void transfer(String accountIdSource,String accountIdDestination,double amount ) throws BankAccountNotFoundException, BalanceNotSufficientException;

     List <BankAccountDTO>bankAccountList();

     customerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

     customerDTO updateCustomer(customerDTO customerDTO);

     void deleteCustomer(long customerId);

     List<AccountOperationDTO> accountHistory(String accountId);



     AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

     List<customerDTO> searchCustomers(String keyword);
}
