package nvc.it.employeehw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nvc.it.employeehw.model.Department;
import nvc.it.employeehw.model.Employee;
import nvc.it.employeehw.model.Project;
import nvc.it.employeehw.repository.DepartmentRepository;
import nvc.it.employeehw.repository.ProjectRepository;
import nvc.it.employeehw.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("")
    public ModelAndView employee(){
        List<Employee> employees = employeeService.findAll();
        return new ModelAndView("employee","employees",employees);
    }

    @GetMapping("/new")
    public String newEmployee(ModelMap modelMap){
        Employee employee = new Employee();
        modelMap.addAttribute("emp", employee);
        return "newemployee";
    }

    @GetMapping("/name/{name}")
    public ModelAndView getEmployeeByName(@PathVariable("name") String name){
        List<Employee> employees = employeeService.findByName(name);
        return new ModelAndView("employee","employees",employees);
    }

    @GetMapping("/salary/{salary}")
    public ModelAndView getEmployeeBySalary(@PathVariable("salary") double salary){
        List<Employee> employees = employeeService.findBySalary(salary);
        return new ModelAndView("employee","employees",employees);
    }

    @PostMapping("/add")
    public String saveEmployee(Employee employee, BindingResult result){
        if(result.hasErrors()){
            return "newemployee";
        }else{
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee emp, BindingResult result){
        if(result.hasErrors()){
            return "editemployee";
        }else{
            Employee employee = employeeService.getById(emp.getId());
            employee.setName(emp.getName());
            employee.setSalary(emp.getSalary());
            employee.setDepartment(emp.getDepartment());
            employee.setProject(emp.getProject());
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        // ดึง product ที่ต้องการลบ ( ตาม id ที่ระบุ )
        Employee employee = employeeService.getById(id);
        employeeService.dalete(employee);;
        return new ModelAndView("redirect:/employee");
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, ModelMap modelMap){
        // ดึง product ที่ต้องการแก้ไข ( ตาม id ที่ระบุ )
        Employee employee = employeeService.getById(id);
        modelMap.addAttribute("emp", employee);
        return "editemployee";
    }

    @ModelAttribute("departments")
    public List<Department> loadDepartments(){
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @ModelAttribute("projects")
    public List<Project> loadProjects(){
        List<Project> projects = projectRepository.findAll();
        return projects;
    }
    
}
