package com.kubino.demo.course;

import java.util.Optional;

public interface CourseService {
    void saveCourse(Course course);
    Optional<Course> findById(int id);
}
