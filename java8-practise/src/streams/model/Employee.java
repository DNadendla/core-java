package streams.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Employee {
    private int id;
    private String department;
    private String name;
    private int age;
    private City city;
    private String gender;
    private List<Role> roles;
    private Date joinDate;
    private Date dateOfBirth;
    private Double salary;

    // Constructor
    public Employee(int id, String name, String department, int age, City city, String gender, List<Role> roles, Date joinDate, Date dateOfBirth, Double salary) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.roles = roles;
        this.joinDate = joinDate;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", gender='" + gender + '\'' +
                ", roles=" + roles +
                ", joinDate=" + joinDate +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                '}';
    }
}