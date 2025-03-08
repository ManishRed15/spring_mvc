package com.example.demo.Controllers;


import com.example.demo.Entity.Employee;
import com.example.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long id){
        Employee emp = employeeService.getEmployeeByID(id);
        if(emp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(id, employee);
        if(emp==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        boolean result = employeeService.deleteEmployee(id);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
