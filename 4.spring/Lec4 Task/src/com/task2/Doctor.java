package com.task2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Doctor {

    @Id
    private Long id;


    private String userName;

  
    private Double salary; 
    
    @OneToOne(mappedBy="doctor")
    private DoctorDetails doctorDetails; 
    
    @ManyToOne()
    @JoinColumn(nullable=false)
    private Hospital hospital;  
    
    @OneToMany(mappedBy="doctor")
    private List<Patient>patients=new ArrayList<>(); 
    



    public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Doctor() {
    }

    public Doctor(String userName, Double salary) {
        this.userName = userName;
        this.salary = salary;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public DoctorDetails getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(DoctorDetails doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", salary=" + salary +
                '}';
    }
}