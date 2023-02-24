package com.bridgelabz.employeepayrollappbackend.repository;

import com.bridgelabz.employeepayrollappbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollRepositories extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee_payroll_service.employee where employee.name=:name",nativeQuery = true)  //this is custom query (optional)
    List<Employee> findByName(String name);
    @Query(value = "select * from employee_payroll_service.department_table where employee.department=:department",nativeQuery = true)
    List<Employee> findByDepartment(String department);
}
