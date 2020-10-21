package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper2.Account2Mapper;
import com.example.demo.service.model.Account;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private Account2Mapper accountMapper2;

	@GetMapping(path = "/{id}")
	public Account findById(@PathVariable Integer id) {
		System.out.println(id);
		Account account = accountMapper.findById(id).orElse(null);
		return account;
	}
	
	@GetMapping(path ="/all")
	public List<Account> getAll() {
		return accountMapper2.getAll();
	}
	
	@GetMapping(path = "/test/{id}")
	public Account findById2(@PathVariable Integer id) {
		Account account = accountMapper2.findById(id).orElse(null);
		return account;
	}
	
	@GetMapping(path ="/test/all")
	public List<Account> getAll2() {
		return accountMapper2.getAll();
	}
	
	@GetMapping(path = "/insert/test1/{name}")
	@Transactional(transactionManager = "transactionManager")
	public void insertTest(@PathVariable String name) throws Exception {
		// rollback
		accountMapper.insert(accountMapper.getMaxId() + 1, name);
		// commit
		accountMapper2.insert(accountMapper2.getMaxId() + 1, name);
		
		// 강제로 예외발생
		int a = 1;
		if(a == 1) {
			throw new RuntimeException();
		}
	}
}
