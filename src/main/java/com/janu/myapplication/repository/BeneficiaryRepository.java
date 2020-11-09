package com.janu.myapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.janu.myapplication.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

    
	@Query(value="SELECT * FROM BENEFICIARY WHERE USER_ID= ?1",nativeQuery = true)
	List<Beneficiary> getBeneficiariesByUserId(Integer userId);


}
