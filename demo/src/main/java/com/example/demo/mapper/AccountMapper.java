package com.example.demo.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.service.model.Account;

@Mapper
public interface AccountMapper {
	@Select("SLT * FROM ACCOUNT WHERE ID = #{id}")
	Optional<Account> findById(int id);

	@Select("SELECT * FROM ACCOUNT")
	List<Account> getAll();

	@Select("SELECT * FROM ACCOUNT WHERE NAME = #{name}")
	List<Account> findByName(String name);

	@Delete("DELETE FROM ACCOUNT WHERE ID = #{id}")
	void deleteById(int id);

	@Select("SELECT MAX(id) FROM ACCOUNT")
	Integer getMaxId();

	@Insert("INSERT INTO ACCOUNT VALUES(#{id}, #{name})")
	void insert(Integer id, String name);
}
