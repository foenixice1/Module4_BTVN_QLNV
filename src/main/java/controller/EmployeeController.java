package controller;

import model.Branch;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IBranchService;
import service.IEmployeeService;
import validate.EmployeeValidate;

import javax.validation.Valid;

@Controller

public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IBranchService iBranchService;

    @Autowired
    private EmployeeValidate employeeValidate;

    @ModelAttribute("branchs")
    private Iterable<Branch> branches() {
        return iBranchService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", iEmployeeService.showAllEmployee());
        return modelAndView;
    }

//    @GetMapping("/home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("list", iEmployeeService.findAll());
//        return modelAndView;
//    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employees", new Employee());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        employeeValidate.validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("employees", employee);
            return modelAndView;
        }
        iEmployeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        modelAndView.addObject("employees", new Employee());
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", iEmployeeService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Employee employee = iEmployeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("employees", employee);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        employeeValidate.validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
                ModelAndView modelAndView = new ModelAndView("edit");
                modelAndView.addObject("employees", employee);
                return modelAndView;
        }
        iEmployeeService.save(employee);
        return new ModelAndView("redirect:/home");

    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        Employee employee = iEmployeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("employees", employee);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute Employee employee) {
        iEmployeeService.delete(employee.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        Employee employee = iEmployeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("employees", employee);
        return modelAndView;
    }
}
