package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.tx.DaoImpl;

@Configuration
@ComponentScan(basePackages = { "com.demo." })

public class Config2 {
	@Bean
	public DaoImpl daoImpl() {
		DaoImpl daoImpl = new DaoImpl();
		return daoImpl;
	}
}
