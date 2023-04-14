package com.recepkabakci.HrManagementSystem.service;

import com.recepkabakci.HrManagementSystem.model.Employee;
import com.recepkabakci.HrManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Optional<Employee> updateEmployee(Long id, Employee employee) {
        Optional<Employee> emp = getEmployeeById(id);
        if (emp.isPresent()) {
            Employee existingEmployee = emp.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            return Optional.of(employeeRepository.save(existingEmployee));
        }
        return Optional.empty();
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}