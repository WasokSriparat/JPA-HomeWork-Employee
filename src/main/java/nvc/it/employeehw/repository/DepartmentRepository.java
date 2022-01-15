package nvc.it.employeehw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.it.employeehw.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    
}
