package validate;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import service.IEmployeeService;


public class EmployeeValidate implements Validator {
    @Autowired
    IEmployeeService iEmployeeService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Iterable<Employee> list = iEmployeeService.findAll();
        Employee employee = (Employee) target;
        for (Employee e : list) {
            if(e.getEmployeeCode().equals(employee.getEmployeeCode())) {
                errors.rejectValue("employeeCode" , "employeeCode.duplicate");
            }
        }
    }
}
