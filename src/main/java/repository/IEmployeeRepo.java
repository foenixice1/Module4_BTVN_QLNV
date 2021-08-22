package repository;

import model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {
//    @Query(value = "SELECT * FROM FPTEmployee.Employee where name like concat('%',:name,'%')", nativeQuery = true)
//    public ArrayList<Employee> findAllByName(@Param("name") String name);

    @Query(value = "SELECT * FROM fptemployee.Employee join fptemployee.Branch on fptemployee.employee.id_branch = fptemployee.branch.id order by  age asc", nativeQuery = true)
    ArrayList<Employee> showAllEmployee();


}
