package nvc.it.employeehw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.employeehw.model.Employee;
import nvc.it.employeehw.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    // Get All Employee
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(int id){
        return employeeRepository.getById(id);
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> findBySalary(double salary){
        return employeeRepository.findBySalaryLessThanEqual(salary);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void dalete(Employee employee){
        employeeRepository.delete(employee);
    }

}
