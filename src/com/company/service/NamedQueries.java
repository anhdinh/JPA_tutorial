package com.company.service;

import com.company.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import static com.company.QueryNames.GET_EMPLOYEE_BY_ID;

public class NamedQueries {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(GET_EMPLOYEE_BY_ID);
        query.setParameter("id", 1L);
        List<Employee> list = query.getResultList();
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}
