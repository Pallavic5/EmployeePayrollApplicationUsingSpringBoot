package com.bridgelabz.employeepayrollappbackend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}\\s{0,}[A-z]{1}[a-z]{2,}", message = "First Letter should be capital.")
    private String name;
    @NotEmpty(message = "Profile Pic is Empty.")
    private String profilePic;
     @NotEmpty(message = "Gender Field should not be null.")
    private String gender;
    @Min(value = 10000,message = "Salary should be more than 10,000!")
    private long salary;
    @Size(min=2,message = "Notes length should be more than 2!")
    private String notes;
    @Past(message = "Start date should be past date!")
    private LocalDate startDate;
    private List<String> department;
}
