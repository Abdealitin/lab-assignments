package com.yash.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void whenSave_shouldReturn_listSizeGreaterThanZero() {
		Employee e = new Employee(0,"test","test");
		
		employeeRepository.save(e);
		
		assertEquals(employeeRepository.findAll().size(),1);
		
	}
}
