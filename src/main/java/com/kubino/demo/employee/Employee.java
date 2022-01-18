package com.kubino.demo.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kubino.demo.company.Company;
import com.kubino.demo.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employment", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @JsonIgnore
    private Company company;

    @ManyToMany
    @JoinTable(
            name = "idOfCourses",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "courseId")
    )
    private Set<Course> courses;

    @Column(name = "company_id")
    private Integer companyId;
}
