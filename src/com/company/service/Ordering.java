package com.company.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Ordering {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query= entityManager.createQuery("select e.ename from Employee  e order by e.ename asc");

        List<String> listName = query.getResultList();

        for (String name :
                listName) {
            System.out.println("Name : "+ name);
        }

    }
}
