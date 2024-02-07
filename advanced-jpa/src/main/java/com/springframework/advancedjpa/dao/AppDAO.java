package com.springframework.advancedjpa.dao;

import com.springframework.advancedjpa.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
}
