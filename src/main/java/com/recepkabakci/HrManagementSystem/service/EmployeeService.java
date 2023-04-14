package com.recepkabakci.HrManagementSystem.service;

import com.recepkabakci.HrManagementSystem.model.Employee;
import com.recepkabakci.HrManagementSystem.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    EmployeeRepository employeeRepository;

    /*
    getAllEmployeList
     */
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    /*
    create employee
     */
    public Employee save( Employee employee) {
        return employeeRepository.save(employee);
    }
    /*
    find employee by id
     */
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }
    /*
    delete employee
     */
    public void  delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
