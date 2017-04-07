package com.demo.tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Repository
public class DaoImpl implements Dao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, transactionManager = "transactionManager")
	public String save(List<Emp> empList) {

		for (Emp e : empList) {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pst = conn
							.prepareStatement("insert into emp(empno,name,city,salary)" + " values(?,?,?,?)");
					pst.setInt(1, e.getEmpId());
					pst.setString(2, e.getEmpName());
					pst.setString(3, e.getCity());
					pst.setDouble(4, e.getSalary());
					return pst;
				}
			});
		}

		return "success";
	}

}
