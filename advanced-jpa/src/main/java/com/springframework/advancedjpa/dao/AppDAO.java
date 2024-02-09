package com.springframework.advancedjpa.dao;

import com.springframework.advancedjpa.entity.*;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    void update(Instructor tempInstructor);
    void updateCourse(Course tempCourse);
    Course findCourseById(int theId);
    void deleteCourseById(int theId);
    void saveCourse(Course theCourse);
    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentsByCourseId(int theId);
    Student findStudentAndCoursesByStudentId(int theId);
    void updateStudent(Student theStudent);
}
