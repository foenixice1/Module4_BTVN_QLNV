package model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
//    @Pattern(regexp = "^[F][P]+[T]+\\d{6}$" , message = "EmployeeCode Must start with FPT followed by 6 numbers")
    private String employeeCode;

    @NotEmpty
//    @Pattern(regexp = "^[^\\d]+$" , message = "Name only letters can't enter numbers")
    private String name;

//    @Min(18)
    private int age;

    private int wage;

    @ManyToOne
    @JoinColumn(name = "id_branch")
    private Branch branch;

    public Employee() {
    }

    public Employee(Integer id, String employeeCode, String name, int age, int wage, Branch branch) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
