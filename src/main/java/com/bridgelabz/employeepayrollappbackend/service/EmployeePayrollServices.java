package com.bridgelabz.employeepayrollappbackend.service;

import com.bridgelabz.employeepayrollappbackend.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollappbackend.exception.EmployeePayrollMessageException;
import com.bridgelabz.employeepayrollappbackend.model.Employee;
import com.bridgelabz.employeepayrollappbackend.repository.EmployeePayrollRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeePayrollServices implements IEmployeeService {
    @Autowired
    EmployeePayrollRepositories repo;

    @Override
    public Employee insertDetails(EmployeeDTO entity) {
        Employee employeeObjectNew = new Employee(entity);
        repo.save(employeeObjectNew);
        return employeeObjectNew;
    }
    @Override
    public Employee updateDetails(int id, EmployeeDTO entity) {
        Employee employee2 = repo.findById(id).get();
        if (repo.findById(id).isPresent()){
            employee2.setName(entity.getName());
            employee2.setProfilePic(entity.getProfilePic());
            employee2.setGender(entity.getGender());
            employee2.setNotes(entity.getNotes());
            employee2.setSalary(entity.getSalary());
            employee2.setStartDate(entity.getStartDate());
            employee2.setDepartment(entity.getDepartment());
            return repo.save(employee2);
        }else{
            throw new EmployeePayrollMessageException("Id is not found");
        }

    }

    @Override
    public Optional<Employee> search(int id) {
        Optional<Employee> employee3 = repo.findById(id);
        if (employee3.isPresent()){
            return employee3;
        }else {
            throw new EmployeePayrollMessageException("Id is not found");
        }
    }

    @Override
    public List<Employee> displayAll() {
        List<Employee> employeeList = repo.findAll();
        return employeeList;
    }

    //Custom Query
    @Override
    public List<Employee> displayNames(String name) {
        List<Employee> employeeNameList = repo.findByName(name);
        if(repo.findByName(name).isEmpty()){
            throw new EmployeePayrollMessageException("Names are not found");
        }else{
            return employeeNameList ;
        }

    }

    @Override
    public List<Employee> displayDepartment(String department) {
        List<Employee> employeeDepartmentList = repo.findByDepartment(department);
        if(repo.findByDepartment(department).isEmpty()){
            throw new EmployeePayrollMessageException("Departments are not found");
        }else{
            return employeeDepartmentList ;
        }
    }
    @Override
    public String deleteById(int id){
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return "Deleted";
        }else {

            throw new EmployeePayrollMessageException("Id are not found");
        }

    }


}
