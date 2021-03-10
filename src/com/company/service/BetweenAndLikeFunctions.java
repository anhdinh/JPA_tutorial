package com.company.service;

import com.company.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BetweenAndLikeFunctions {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT e from Employee  e where e.salary between 3000 and 4000");
        List<Employee> empls = query.getResultList();

        for (Employee e: empls) {
            System.out.println(e);
        }

        // Like

        Query query1 = entityManager.createQuery("SELECT e from Employee e where e.ename like 'M%'");

        List<Employee> list1 =  query1.getResultList();

        for (Employee e :
                list1) {
            System.out.println("name : "+e.getEname());
        }
    }
}
