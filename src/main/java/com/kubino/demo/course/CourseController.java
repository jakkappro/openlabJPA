package com.kubino.demo.course;

import com.kubino.demo.employee.Employee;
import com.kubino.demo.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    private final CourseService service;
    private final EmployeeService employeeService;

    public CourseController(@Autowired CourseService service, @Autowired EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @GetMapping("/courses/get/{id}")
    public Course findCourse(@PathVariable int id) {
        return service.findById(id).isPresent() ?  service.findById(id).get() : null;
    }

    @PostMapping("courses/new")
    public void createCourse(@RequestBody Course course) {
        service.saveCourse(course);
    }
}
