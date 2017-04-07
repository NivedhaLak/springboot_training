package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class App {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");

		int rows = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,city,salary) values(?,?,?,?)");
				pst.setInt(1, 111);
				pst.setString(2, "Scott");
				pst.setString(3, "London");
				pst.setDouble(4, 40000);
				return pst;
			}
		});
		System.out.println("Rows Inserted : " + rows);
	}
}
