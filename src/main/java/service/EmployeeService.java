package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.IEmployeeRepo;

import java.util.ArrayList;
import java.util.Optional;

public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;


    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return iEmployeeRepo.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public void delete(Integer id) {
        iEmployeeRepo.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepo.findAll(pageable);
    }

    @Override
    public ArrayList<Employee> findAllByName(String name) {
        return null;
    }
}
