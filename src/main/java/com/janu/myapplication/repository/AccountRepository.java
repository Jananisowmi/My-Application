package com.janu.myapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.janu.myapplication.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findAccountByAccountNumber(String fromAccount);
	
    @Modifying
    @Query(value="update Account set balance=?2 where ACCOUNT_NUMBER=?1 ", nativeQuery=true)
	void updateBalance(String fromAccount, Double balance);

}
