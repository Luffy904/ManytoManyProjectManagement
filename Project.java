package com.example.ManytoMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="WiproProject")
public class Project {
	@Id
	private int pid;
	private String title;
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="projects")
	private List<Employee> employees= new ArrayList<Employee>();;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
