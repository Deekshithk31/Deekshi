package com.abc.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	           @JoinTable(name="employee_project",
	           joinColumns=@JoinColumn(name="employee_id"),
	           inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> project;

	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	
	

}
