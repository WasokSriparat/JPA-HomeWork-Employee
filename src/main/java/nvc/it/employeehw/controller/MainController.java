package nvc.it.employeehw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import nvc.it.employeehw.model.Department;
import nvc.it.employeehw.model.Project;
import nvc.it.employeehw.repository.DepartmentRepository;
import nvc.it.employeehw.repository.ProjectRepository;

@Controller
public class MainController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/department")
    public ModelAndView department(){
        List<Department> departments = departmentRepository.findAll();
        return new ModelAndView("department","departments",departments);
    }

    @GetMapping("/project")
    public ModelAndView project(){
        List<Project> projects = projectRepository.findAll();
        return new ModelAndView("project","projects",projects);
    }

}
