package com.bridgelabz.employeepayrollappbackend.model;

import com.bridgelabz.employeepayrollappbackend.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee {
    @Id //it is denoting as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //It is used to Autoincreement ID.
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String profilePic;
    private String gender;
    private long salary;
    private String notes;
    private LocalDate startDate;

    @ElementCollection
    @CollectionTable(name = "department_table",joinColumns = @JoinColumn(name = "id"))      //join the table with primary key(id)
    @Column(name = "department")
    private List<String> department;


    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.profilePic = employeeDTO.getProfilePic();
        this.gender = employeeDTO.getGender();
        this.salary = employeeDTO.getSalary();
        this.notes = employeeDTO.getNotes();
        this.startDate = employeeDTO.getStartDate();
        this.department = employeeDTO.getDepartment();
    }


}
