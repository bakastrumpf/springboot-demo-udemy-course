package com.springframework.advancedjpa;

import com.springframework.advancedjpa.dao.AppDAO;
import com.springframework.advancedjpa.entity.Instructor;
import com.springframework.advancedjpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AdvancedJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// System.out.println("Hello, world!");
			createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetailById(appDAO);
		};
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
		appDAO.deleteInstuctorById(theId);
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
