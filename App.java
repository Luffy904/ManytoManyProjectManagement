package com.example.ManytoMany;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
    	Configuration con1=new Configuration().configure().addAnnotatedClass(Project.class);
    	
    	SessionFactory ss=con.buildSessionFactory();
    	Session s=ss.openSession();
    	Transaction t1=s.beginTransaction();
    	Employee e1=new Employee();
    	e1.setEid(1);
    	e1.setName("Amit");
    	e1.setPosition("Engineer");
    	Project p1=new Project();
    	p1.setPid(11);
    	p1.setTitle("Hospital Management");
    	Project p2=new Project();
    	p2.setPid(12);
    	p2.setTitle("Employee Management");
    	e1.getProjects().add(p1);
    	e1.getProjects().add(p2);
    	p1.getEmployees().add(e1);
    	p2.getEmployees().add(e1);
    	s.persist(e1);
    	t1.commit();
    }
}
