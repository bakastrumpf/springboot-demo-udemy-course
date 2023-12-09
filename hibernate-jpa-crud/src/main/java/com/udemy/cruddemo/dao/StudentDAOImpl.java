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
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		// create query 		
//		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
				
		// return query results		
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		
		// create query		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName:=tehData", Student.class);
			
		// set query parameteres		
		theQuery.setParameter("theData", theLastName);
		
		// return query results		
		return theQuery.getResultList();
	}

	@Override
	@Transactional // adding this annotation as we are updating DB
	public void update(Student theStudent) {
		
		// update student		
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional // adding this because  we are performing a delete 
	public void delete(Integer id) {
		
		// retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
		
		// delete the student
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional // adding this annotation as we are updating DB
	public int deleteAllStudents() {
		
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		// System.out.println("Successfully deleted " + numRowsDeleted);
		return numRowsDeleted;
	}
	
	

	
}
