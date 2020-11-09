package com.janu.myapplication.service;

import com.janu.myapplication.entity.Account;
import com.janu.myapplication.entity.User;

public interface AccountService {

	Account saveAccount(User created, Double balance);

}
