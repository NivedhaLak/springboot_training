import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.Config;
import com.demo.tx.Dao;
import com.demo.tx.Emp;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		Dao dao= (Dao)ctx.getBean("daoImpl");
		
		List<Emp> empList= new ArrayList<>();
		empList.add(new Emp(307,"Ratan","Pune",30000));
		empList.add(new Emp(808,"Chetan","Pune",30000));
		empList.add(new Emp(209,"Ketan","Pune",30000));
		empList.add(new Emp(305,"Jiten","Pune",30000));
		empList.add(new Emp(311,"Kitten","Pune",30000));
		
		dao.save(empList);

		
	}

}
