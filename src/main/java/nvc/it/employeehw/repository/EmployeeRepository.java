package nvc.it.employeehw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.it.employeehw.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    // Find Employee BY Name
    public List<Employee> findByNameContaining(String name);

    // Find Employee BY Salary
    public List<Employee> findBySalaryLessThanEqual(double salary);
    
}
