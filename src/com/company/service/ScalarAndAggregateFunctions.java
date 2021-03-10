package com.company.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ScalarAndAggregateFunctions {

    public static void main(String[] args){
        System.out.println("--------");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("Select UPPER(e.ename)  from Employee  e");
        List<String> list =  query.getResultList();

        for (String e: list) {
            System.out.println("Employee name :"+ e);
        }

        Query query1 =  entityManager.createQuery("SELECT  MAX(e.salary) from Employee e");

        Double result =(Double) query1.getSingleResult();

        System.out.println("Max Employee Salary "+ result);


    }
}
