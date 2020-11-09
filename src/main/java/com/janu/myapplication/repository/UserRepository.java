package com.janu.myapplication.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janu.myapplication.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


	@Modifying
	@Query(value="update user set aid=?1 where user_id=?2", nativeQuery = true)
	void updateAccountId(int aId, int userId);

	User findUserByUserNameAndPasswordAndEmailId(String userName, String password, String emailId);

	@Query(value = "SELECT * FROM USER WHERE AID = ?1 ", nativeQuery = true)
	User findUserByAccount(Integer accountId);
	
	


	

	
}
