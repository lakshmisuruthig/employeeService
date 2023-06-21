package com.practise.employeeService.rest;

import com.practise.employeeService.entity.Employee;
import com.practise.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
private EmployeeService employeeService;
@Autowired
public EmployeeRestController(EmployeeService employeeService){
    this.employeeService=employeeService;
}

@GetMapping("/employees")
    public List<Employee> getEmployeeList(){
    return employeeService.findAll();
}

@GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
     return Optional.ofNullable(employeeService.findById(empId))
             .orElseThrow(() -> new RuntimeException("Employee Not Found - " + empId));
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeService.save(emp);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId){
     employeeService.deleteById(empId);
      return "Deleted employee id" + " " + empId;
    }
}
