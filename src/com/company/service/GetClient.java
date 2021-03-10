package com.company.service;

import com.company.entity.NonTeachingStaff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetClient {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        NonTeachingStaff nonTeachingStaff = entityManager.find(NonTeachingStaff.class,7);
        nonTeachingStaff.setSname("Anhdinh");
        nonTeachingStaff.setAreaexpertise("Accountssss");
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

//
//        NonTeachingStaff nonTeachingStaff = entityManager.find(NonTeachingStaff.class,7);
//
//        System.out.println("ID : "+nonTeachingStaff.getSid());
//        System.out.println("Name : "+nonTeachingStaff.getSname());
//        System.out.println("Area Expertise : "+nonTeachingStaff.getAreaexpertise());

    }
}
