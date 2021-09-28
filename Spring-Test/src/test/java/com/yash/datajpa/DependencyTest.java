package com.yash.datajpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DependencyTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
//	@Autowired
//	Session session;
	
	@PersistenceContext
	EntityManager entityManager;

	@Test
	public void checkInjectedComponentsAreNotNull() {
		Assert.assertNotNull(dataSource);
		Assert.assertNotNull(applicationContext);
		Assert.assertNotNull(entityManager);
	}
	
}
