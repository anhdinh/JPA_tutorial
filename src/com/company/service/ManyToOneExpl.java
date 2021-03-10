package com.company.service;

import com.company.entity.Employee;
import com.company.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneExpl {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

        EntityManager entityManager =entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Department department = new Department();

        department.setName("Developer");

        Department department2 = new Department("Manager");


        entityManager.persist(department);
        entityManager.persist(department2);

        Employee employee1 =  new Employee("anhdinh",4000D,"developer");
        employee1.setDep(department);

        Employee employee2 =  new Employee("thuy nguyen",5000D,"Manager");
        employee2.setDep(department2);

        Employee employee3 = new Employee("Dan nguyen",4000D,"developer");

        employee3.setDep(department);

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
