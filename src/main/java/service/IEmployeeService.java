package service;

import model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IEmployeeService extends IGeneralService<Employee>{
    Page<Employee> findAll(Pageable pageable);
    ArrayList<Employee> findAllByName(String name);

}
