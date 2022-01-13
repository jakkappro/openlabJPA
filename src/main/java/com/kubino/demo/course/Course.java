package com.kubino.demo.course;

import com.kubino.demo.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToMany(mappedBy = "courses")
    private Set<Employee> attendance;
}
