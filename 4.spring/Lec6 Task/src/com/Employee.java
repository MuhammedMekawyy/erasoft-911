package com;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "id") // FK to person.id (JOINED strategy)
public class Employee extends Person {

    @Column(name = "salary")
    private Double salary;

    @Column(name = "department")
    private String department;

    public Employee() {
    }

    public Employee(String name, Double salary, String department) {
        super(name);
        this.salary = salary;
        this.department = department;
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
        return "Employee{id=" + getId() + ", name='" + getName() + "', salary=" + salary
                + ", department='" + department + "'}";
    }
}