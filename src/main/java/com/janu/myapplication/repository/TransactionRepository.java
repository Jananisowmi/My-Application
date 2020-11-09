package com.janu.myapplication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.janu.myapplication.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value = "SELECT * FROM TRANSACTION WHERE USER_ID = ?1", nativeQuery = true)
	List<Transaction> findTransactionByUser(Integer userId);

	@Query(value = "select * from transaction where timestamp >= ?2 AND timestamp <= ?3 AND user_id = ?1", nativeQuery = true)
	List<Transaction> findTransactionByDate(Integer userId, Date fromDate, Date toDate);

}
