package com;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Course911")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int price;
	
	public Course(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@ManyToMany(mappedBy = "courses" , cascade = CascadeType.PERSIST)
	private List<Student> students;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course(Long id, String name, int price, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.students = students;
	}

	public Course(String name, int price, List<Student> students) {
		super();
		this.name = name;
		this.price = price;
		this.students = students;
	} 
	
	
}
