package com.springframework.advancedjpa.dao;

import com.springframework.advancedjpa.entity.Instructor;
import com.springframework.advancedjpa.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstuctorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
}
