package com.arisu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.arisu.bean.Employee;

public interface EmployeeMapper {

	@MapKey("id")
	public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	public Employee getEmpByIdAndLastName(@Param("xx")Integer id,@Param("lastName")String lastName);
	
	public Employee getEmpById(Integer id);
	
	public boolean addEmp(Employee employee);
	
	public Employee getEmpAndDept(Integer id);
	
	public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);
	
	public List<Employee> getEmpsTestInnerParam(Employee employee);
}
