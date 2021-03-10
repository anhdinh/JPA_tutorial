package com.company.service;

import com.company.entity.Class;
import com.company.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class ManyToManyExample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = factory.createEntityManager();
        try {
            case2(entityManager,factory);
           // case1(entityManager,factory);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void case1(EntityManager entityManager, EntityManagerFactory factory) throws Exception {
        try {


            entityManager.getTransaction().begin();

            Class class1 = new Class("Introduction information technology");
            Class class2 = new Class("Basic DBMS");
            Class class3 = new Class("Entropy");

            entityManager.persist(class1);
            entityManager.persist(class2);
            entityManager.persist(class3);

            Set classSet1 = new HashSet();

            classSet1.add(class1);
            classSet1.add(class2);
            classSet1.add(class3);

            Set classSet2 = new HashSet();

            classSet2.add(class3);
            classSet2.add(class1);
            classSet2.add(class2);

            Set classSet3 = new HashSet();

            classSet3.add(class2);
            classSet3.add(class3);
            classSet3.add(class1);

            Teacher teacher1 = new Teacher("Anh Dinh", "JAVA");
            Teacher teacher2 = new Teacher("Jonathan", "DB2");
            Teacher teacher3 = new Teacher("Kindred", "Design - Program");

            teacher1.setClassSet(classSet1);
            teacher2.setClassSet(classSet2);
            teacher3.setClassSet(classSet3);

            entityManager.persist(teacher1);
            entityManager.persist(teacher2);
            entityManager.persist(teacher3);

            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            entityManager.close();
            factory.close();
            throw ex;
        }
    }

    public static void case2(EntityManager entityManager, EntityManagerFactory factory) throws Exception {
        try {


            entityManager.getTransaction().begin();

            Teacher teacher1 = new Teacher("Anh Dinh 2", "JAVA 2");
            Teacher teacher2 = new Teacher("Jonathan 2", "DB2");
            Teacher teacher3 = new Teacher("Kindred 2", "Design - Program");

            entityManager.persist(teacher1);
            entityManager.persist(teacher2);
            entityManager.persist(teacher3);

            Set teacherSet1 = new HashSet();

            teacherSet1.add(teacher1);
            teacherSet1.add(teacher2);
            teacherSet1.add(teacher3);

            Class class1 = new Class("class1 _ 2");
            class1.setTeacher(teacherSet1);

            Class class2 = new Class("class2 _ 2");
            class2.setTeacher(teacherSet1);

            Class class3 = new Class("class3_ 2");
            class3.setTeacher(teacherSet1);

            entityManager.persist(class1);
            entityManager.persist(class2);
            entityManager.persist(class3);

            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            entityManager.close();
            factory.close();
        }

    }
}
