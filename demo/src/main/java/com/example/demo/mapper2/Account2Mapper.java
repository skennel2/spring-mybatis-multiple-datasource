package com.example.demo.mapper2;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.service.model.Account;

@Mapper
public interface Account2Mapper {
	@Select("SELECT * FROM ACCOUNT2 WHERE ID = #{id}")
	Optional<Account> findById(int id);
	
	@Select("SELECT * FROM ACCOUNT2")
	List<Account> getAll();
	
	@Select("SELECT * FROM ACCOUNT2 WHERE NAME = #{name}")
	List<Account> findByName(String name);
	
	@Delete("DELETE FROM ACCOUNT2 WHERE ID = #{id}")
	void deleteById(int id);
	
	@Select("SELECT MAX(id) FROM ACCOUNT2")
	Integer getMaxId();
	
	@Insert("INSERT INTO ACCOUNT2 VALUES(#{id}, #{name})")
	void insert(Integer id, String name);
}
