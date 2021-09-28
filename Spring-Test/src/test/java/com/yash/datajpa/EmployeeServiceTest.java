package com.yash.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;
import com.yash.datajpa.service.EmployeeService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Rollback(false)
	@Transactional
	public void givenName_shouldReturn_employeeRecordWithSameName() {
		Employee e = new Employee(0,"test","test");
		
		employeeRepository.save(e);
		
		assertEquals(employeeService.getEmpByName("test").get().getName(), "test");
	}
}
