package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class App2 {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");

		List<String> empList = jt.query("select * from emp", new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {

				return rs.getString("empno") + " " + rs.getString("name") + " " + rs.getString("city") + " "
						+ rs.getString("salary");
			}
		});

		for (String s : empList) {
			System.out.println(s);
		}
		
		int num=jt.queryForObject("select max(empno) from emp", Integer.class);
		System.out.println(num);
	}
}
