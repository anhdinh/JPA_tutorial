package com.company.service;

import com.company.entity.Department;
import com.company.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class OneToManyExample {

    public static void main(String[] args) {
        EntityManagerFactory efactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = efactory.createEntityManager();

        entityManager.getTransaction().begin();
        Department hrDepartment =  new Department();

        hrDepartment.setName("HR");

        Employee employee1 = new Employee("Hoa nguyen",4000D,"director");
        Employee employee2 = new Employee("Nu nguyen",2000D,"staff");
        Employee employee3 = new Employee("Ngoc Lam",2000D,"staff");
        Employee employee4 = new Employee("Dang Dinh",2000D,"staff");

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);

        List<Employee> listEmployee = new ArrayList<>();

        listEmployee.add(employee1);
        listEmployee.add(employee2);
        listEmployee.add(employee3);
        listEmployee.add(employee4);
        hrDepartment.setEmployeeList(listEmployee);

        entityManager.persist(hrDepartment);

        entityManager.getTransaction().commit();
        entityManager.close();
        efactory.close();

    }
}
