package com.springframework.advancedjpa;

import com.springframework.advancedjpa.dao.AppDAO;
import com.springframework.advancedjpa.entity.Course;
import com.springframework.advancedjpa.entity.Instructor;
import com.springframework.advancedjpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AdvancedJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// System.out.println("Hello, world!");
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetailById(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetcg(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 15;

		// find the instructor
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update data for the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Comedy 2");
		appDAO.updateCourse(tempCourse);
		System.out.println("Successfully updated the course id " + theId + " to the title " + tempCourse.getTitle());
		System.out.println("Done");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 6;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update data for the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Peters");
		appDAO.update(tempInstructor);
		System.out.println("Successfully updated the instructor id " + theId + " to the last name " + tempInstructor.getLastName());
		System.out.println("Done");

	}

	private void findInstructorWithCoursesJoinFetcg(AppDAO appDAO) {

		int theId = 6;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("temp instructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());

		System.out.println("Done! ");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 6;

		// find the instructor
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("temp instructor: " + tempInstructor);

		// find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done! ");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 6;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());
		System.out.println("Done! ");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Samantha", "Sanders", "samantha@bh90210.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/beverlyhills90210","acting");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Theatre 1");
		Course tempCourse2 = new Course("Drama 1");
		Course tempCourse3 = new Course("TV shows 1");
		Course tempCourse4 = new Course("Comedy 1");
		Course tempCourse5 = new Course("Theatre 2");
		Course tempCourse6 = new Course("Drama 2");

		// add courses to the instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);
		tempInstructor.add(tempCourse4);
		tempInstructor.add(tempCourse5);
		tempInstructor.add(tempCourse6);

		// save the instructor
		// this will also save courses
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done! ");

	}

	private void deleteInstructorDetailById(AppDAO appDAO) {

		int theId = 6;
		System.out.println("Deleting instructor detail id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Successfully deleted instructor detail id " + theId);

	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 1;
		System.out.println("Finding instructor detail id: " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		
		// print the associated instructor
		System.out.println("associated instructor: " + tempInstructorDetail.getTheInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Successfully deleted instructor id: " + theId);

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Cindy", "Walsh", "cindy@bh90210.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/beverlyhills90210","gardening");

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Felice", "Martin", "felice@bh90210.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/beverlyhills90210","shopping");

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Jack", "McKay", "jack@bh90210.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/beverlyhills90210","finances");

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Bill", "Taylor", "bill@bh90210.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/beverlyhills90210","unknown");
*/
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Rush", "Sanders", "rush@bh90210.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/beverlyhills90210","baseball");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save instructor
		// this will also save the details obect
		// because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);

		appDAO.save(tempInstructor);

	}

}
