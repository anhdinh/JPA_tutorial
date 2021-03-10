package com.company.service;

import com.company.entity.NonTeachingStaff;
import com.company.entity.TeachingStaff;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveClient {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TeachingStaff teachingStaff1 = new TeachingStaff("Gopal","MSc MEd","Maths");
        TeachingStaff teachingStaff2 = new TeachingStaff("Manisha","BSc BEd","English");

        NonTeachingStaff nts1=new NonTeachingStaff( "Satish", "Accounts");
        NonTeachingStaff nts2=new NonTeachingStaff( "Krishna", "Office Admin");

        entityManager.persist(teachingStaff1);
        entityManager.persist(teachingStaff2);
        entityManager.persist(nts1);
        entityManager.persist(nts2);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
