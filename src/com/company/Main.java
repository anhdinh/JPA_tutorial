package com.company;

import com.company.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main(String[] args) {
        EntityManagerFactory  managerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entitymanager = managerFactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        Employee employee = new Employee( );
        //employee.setEid( 1201 );
        employee.setEname( "sion" );
        employee.setSalary( 40000 );
        employee.setDeg( "Manager" );
        entitymanager.persist( employee );
        entitymanager.getTransaction( ).commit( );
        entitymanager.close( );
        managerFactory.close( );
    }
}
