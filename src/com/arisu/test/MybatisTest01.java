package com.arisu.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.arisu.bean.Employee;
import com.arisu.dao.EmployeeMapper;

public class MybatisTest01 {

	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test() throws IOException{
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		// EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		// Employee empById = mapper.getEmpById(1);
		//System.out.println(empById);
		// Employee emp = new Employee("xiaorang", "xiaorang@11.com", "1");  
		 //mapper.addEmp(emp);
		 //System.out.println(emp);
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee emp = mapper.getEmpByIdAndLastName(1, "com");
			System.out.println(emp);
		 
		 //手动提交
		 session.commit();
		} finally {
		  session.close();
		}
	}
	
	@Test
	public void test01() throws IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			//List<Employee> emps = mapper.getEmpsByConditionForeach(Arrays.asList(1,2,3,4));
			Employee emp = new Employee("co", null, null);
			List<Employee> emps = mapper.getEmpsTestInnerParam(emp);
			System.out.println(emps.size());
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}
