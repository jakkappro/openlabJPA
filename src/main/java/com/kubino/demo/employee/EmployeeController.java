package com.kubino.demo.employee;

import com.kubino.demo.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService service;
    private final CourseService courseService;

    public EmployeeController(@Autowired EmployeeService service, @Autowired CourseService courseService) {
        this.service = service;
        this.courseService = courseService;
    }

    @PostMapping("/employee/new")
    public void addEmployees(@Valid @RequestBody List<Employee> employees) {
        for (var employee : employees) {
            service.saveEmployee(employee);
        }
    }

    @GetMapping("/employee/get/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.findById(id).isPresent() ? service.findById(id).get() : null;
    }

    @PostMapping("/employee/addCourse")
    public void addCourse(@RequestParam int courseId, @RequestParam int studentId) {
        var student = service.findById(studentId).get();
        student.getCourses().add(courseService.findById(courseId).get());
        service.saveEmployee(student);
    }
}
