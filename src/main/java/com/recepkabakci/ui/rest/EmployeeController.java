package com.recepkabakci.ui.rest;
import com.recepkabakci.business.dto.EmployeeDto;
import com.recepkabakci.exception.EmployeeNotFoundException;
import com.recepkabakci.data.entity.EmployeeEntity;
import com.recepkabakci.business.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    //ListEmployee
    //http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> employeeDtoList=employeeService.getAllEmployees();
        return employeeDtoList;
    }

    //FindById
    //http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        List<EmployeeDto> employeeDtoList=employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList.get(0));
    }

    //CreateEmployee
    //http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.createEmployee(employeeDto);
        return employeeDto;
    }

    //UpdateEmployee
    //http://localhost:8080/api/v1/employees/1
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto) throws Throwable {
        employeeService.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    //DeleteEmployee
    //http://localhost:8080/api/v1/employees/1
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable{
        employeeService.deleteEmployee(id);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
