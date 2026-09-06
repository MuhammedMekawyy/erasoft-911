package com.task2;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Hospital {

    @Id
    private Long id;

 
    private String name;

    
    private int numberOfDoctors;

   
    private int numberOfPatient;  
    
    
    @OneToMany(mappedBy="hospital")
    private List<Doctor> doctors = new ArrayList<>(); 
    
    
    @ManyToMany(mappedBy = "hospitals")
    private List<Patient> patients = new ArrayList<>(); 

    

    public Hospital() {
    }

    public Hospital(String name, int numberOfDoctors, int numberOfPatient) {
        this.name = name;
        this.numberOfDoctors = numberOfDoctors;
        this.numberOfPatient = numberOfPatient;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDoctors() {
        return numberOfDoctors;
    }

    public void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    public int getNumberOfPatient() {
        return numberOfPatient;
    }

    public void setNumberOfPatient(int numberOfPatient) {
        this.numberOfPatient = numberOfPatient;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfDoctors=" + numberOfDoctors +
                ", numberOfPatient=" + numberOfPatient +
                '}';
    }
}
