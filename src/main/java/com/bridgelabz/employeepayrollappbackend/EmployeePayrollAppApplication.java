package com.bridgelabz.employeepayrollappbackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j      //this annotation for logger
public class EmployeePayrollAppApplication {
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Payroll App...");
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Hello Logger!!!");        //logger added here
    }
}
