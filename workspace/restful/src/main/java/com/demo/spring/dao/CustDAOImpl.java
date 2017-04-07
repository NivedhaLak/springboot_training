package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.demo.spring.Customer;
import com.demo.spring.ListEntity;

public class CustDAOImpl implements CustDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(final Customer c) {
		int count = 0;
		count = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pst = con
						.prepareStatement("insert into customers(custId,name,address,email) values (?,?,?,?)");
				pst.setString(1, c.getCustId());
				pst.setString(2, c.getName());
				pst.setString(3, c.getAddress());
				pst.setString(4, c.getEmail());
				return pst;
			}
		});
		return count;
	}

	@Override
	public Customer getCust(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListEntity getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCust(int id) {
		// TODO Auto-generated method stub

	}

}
