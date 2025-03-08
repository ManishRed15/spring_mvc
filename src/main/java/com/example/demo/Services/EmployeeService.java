package com.example.demo.Services;


import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){

        if(employeeRepository.existsById(id)){
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        }
        else
            return null;

    }

    public boolean deleteEmployee(Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
