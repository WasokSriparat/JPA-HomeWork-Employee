package nvc.it.employeehw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.it.employeehw.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>{
    
}
