package com.bridgelabz.employeepayrollappbackend.service;

import com.bridgelabz.employeepayrollappbackend.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollappbackend.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee insertDetails(EmployeeDTO entity);
    Employee updateDetails(int id, EmployeeDTO entity);
    Optional<Employee> search(int id);
    List<Employee> displayAll();
    List<Employee> displayNames(String name);

    List<Employee> displayDepartment(String department);

    String deleteById(int id);
}
