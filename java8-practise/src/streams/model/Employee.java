package streams.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private City city;
    private String gender;
    private List<Role> roles;

    // Constructor
    public Employee(int id, String name, int age, City city, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.roles = new ArrayList<>();
    }

    // Constructor with roles
    public Employee(int id, String name, int age, City city, String gender, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.roles = roles;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", gender='" + gender + '\'' +
                ", roles=" + roles +
                '}';
    }
}