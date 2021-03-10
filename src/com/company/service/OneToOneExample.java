package com.company.service;

import com.company.entity.Card;
import com.company.entity.Department;
import com.company.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Card card = new Card(1234L);

            entityManager.persist(card);
            Employee employee = new Employee("zing",5000,"ceo ");
            employee.setCard(card);

            Department department = entityManager.find(Department.class,16);

            employee.setDep(department);

            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            entityManager.close();
            entityManagerFactory.close();
        }







    }
}
