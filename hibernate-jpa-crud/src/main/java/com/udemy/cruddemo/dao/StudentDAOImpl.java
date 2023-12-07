package com.udemy.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.cruddemo.Entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// define field for entity manager
	
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	// implement save method
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		// create query 
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
		
		
		// return query results
		
		return theQuery.getResultList();
	}
	
	

	
}
