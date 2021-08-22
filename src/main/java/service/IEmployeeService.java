package service;

import model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IEmployeeService extends IGeneralService<Employee>{
    ArrayList<Employee> showAllEmployee();
    ArrayList<Employee> findAllByName(String name);

}
