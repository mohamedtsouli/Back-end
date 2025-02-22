package com.example.ebankbackend.repositories;

import com.example.ebankbackend.entities.AccountOperation;
import com.example.ebankbackend.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
 List<AccountOperation> findByBankAccountId(String accountId);
 Page<AccountOperation> findByBankAccountIdOrderByOperationDAteDesc(String accountId, Pageable pageable);

}
