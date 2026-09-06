package com.task2;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class DoctorDetails {

    @Id
    private Long id;


    private String fukkAddress;

   
    private String firstName;

   
    private String lastName;

  
    private Integer age; 
    
    @OneToOne
    @JoinColumn(nullable=false,unique = true)
    private Doctor doctor;



    public DoctorDetails() {
    }

    public DoctorDetails(String fukkAddress, String firstName, String lastName, Integer age) {
        this.fukkAddress = fukkAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFukkAddress() {
        return fukkAddress;
    }

    public void setFukkAddress(String fukkAddress) {
        this.fukkAddress = fukkAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorDetails{" +
                "id=" + id +
                ", fukkAddress='" + fukkAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
