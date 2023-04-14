package com.recepkabakci.HrManagementSystem.controller;
import com.recepkabakci.HrManagementSystem.exception.EmployeeNotFoundException;
import com.recepkabakci.HrManagementSystem.model.Employee;
import com.recepkabakci.HrManagementSystem.repository.EmployeeRepository;
import com.recepkabakci.HrManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //  build get all employee  REST API
    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    // build create employee REST API
    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeService.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id: " + id));

        employeeService.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
