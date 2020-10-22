package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.example.demo.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2")
public class DataSource2Config {
	@Bean(name = "dataSource2")
	public DataSource dataSource2() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
		dataSource.setUsername("postgres");
		dataSource.setPassword("1111");
		return dataSource;
	}

	@Bean(name = "sqlSessionFactory2")
	public SqlSessionFactory sqlSessionFactory2() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource2());

		return ssfb.getObject();
	}

	@Bean(name = "transactionManager2")
	public DataSourceTransactionManager transactionManager2() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource2());
		return transactionManager;
	}
}
