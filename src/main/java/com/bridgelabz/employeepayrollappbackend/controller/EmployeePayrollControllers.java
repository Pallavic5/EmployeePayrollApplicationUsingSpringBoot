package com.bridgelabz.employeepayrollappbackend.controller;

import com.bridgelabz.employeepayrollappbackend.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollappbackend.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappbackend.model.Employee;
import com.bridgelabz.employeepayrollappbackend.repository.EmployeePayrollRepositories;
import com.bridgelabz.employeepayrollappbackend.service.EmployeePayrollServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayrollControllers {
    @Autowired
    EmployeePayrollServices employeePayrollServices;
    @Autowired
    EmployeePayrollRepositories employeePayrollRepositories;

    /*GetMApping means fetching all details from database*/
    @GetMapping("/param/{name}")
    public String sendParameter(@PathVariable String name){
        return "Hello " + "Mr/Mrs. " + name + " Welcome to Employee Payroll Application!!!";
    }

    //Insert details into database table
    @PostMapping("/addDetails")
    public ResponseEntity<ResponseDTO> addDetails(@Valid @RequestBody EmployeeDTO entity){         //Before @RequestBody we have to add @Valid
        Employee employee1 = employeePayrollServices.insertDetails(entity);
        ResponseDTO responseDTO = new ResponseDTO("Data Inserted Successfully!!", employee1);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")    //to update
    public ResponseEntity<ResponseDTO> updateData(@PathVariable int id, @Valid @RequestBody EmployeeDTO entity ){  //insert update (requestbody)
        Employee employee2 = employeePayrollServices.updateDetails(id,entity);
        ResponseDTO responseDTO = new ResponseDTO("Data has been Updated!!", employee2);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){ //findout id (pathvariable)
//        employeePayrollRepositories.deleteById(id);
//        ResponseDTO responseDTO = new ResponseDTO("Data has been deleted!!","Successful!!");
//        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){ //findout id (pathvariable)
        String employee = employeePayrollServices.deleteById(id);
        ResponseDTO responseDTO = new ResponseDTO("Data has been deleted!!",employee);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<ResponseDTO> findId(@PathVariable int id){
//        Employee employeeFindId = employeePayrollServices.search(id);
//        ResponseDTO responseDTO = new ResponseDTO("Data has been found!!",employeeFindId);
//        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
//    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> findId(@PathVariable int id){
        Optional<Employee> employeeFindId = employeePayrollServices.search(id);
        ResponseDTO responseDTO = new ResponseDTO("Data has been found!!",employeeFindId);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @GetMapping("/getAllDetails")
    public ResponseEntity<ResponseDTO> getAllDetails(){
        List<Employee> employeeList = employeePayrollServices.displayAll();
        ResponseDTO responseDTO = new ResponseDTO("All Data has been found!!",employeeList);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<ResponseDTO> getAllNames(@PathVariable String name){
        List<Employee> employeeNameList = employeePayrollServices.displayNames(name);
        ResponseDTO responseDTO = new ResponseDTO("All the names are found here!!",employeeNameList);
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }

    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<ResponseDTO> getAllDepartments(@PathVariable String department){
        List<Employee> employeeDepartmentList = employeePayrollServices.displayDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("All the departments are found here!!",employeeDepartmentList);
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }

}
