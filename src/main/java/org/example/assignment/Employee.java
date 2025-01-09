package org.example.assignment;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private int age;
    private String designation;
    private Gender gender;
    private String department;

    public Employee(int id, String name, int salary, int age, String designation, Gender gender, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.designation = designation;
        this.gender = gender;
        this.department = department;
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", gender=" + gender +
                ", department='" + department + '\'' +
                '}';
    }
}
