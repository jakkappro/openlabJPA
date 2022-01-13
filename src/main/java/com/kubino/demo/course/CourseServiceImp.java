package com.kubino.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImp(@Autowired CourseRepository repository) {
        this.repository = repository;
    }

    public void saveCourse(Course course) {
        repository.save(course);
    }

    public Optional<Course> findById(int id) {
        return repository.findById(id);
    }
}
