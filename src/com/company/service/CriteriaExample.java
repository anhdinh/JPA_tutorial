package com.company.service;

import com.company.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaExample {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> from = cq.from(Employee.class);

        CriteriaQuery<Employee> employeeSelectAll = cq.select(from);//where(cb.equal(from.get("eid"),2));

        employeeSelectAll.orderBy(cb.asc(from.get("ename")));

        TypedQuery<Employee> typedQuery = entityManager.createQuery(employeeSelectAll);

        List<Employee> resultList = typedQuery.getResultList();

        System.out.println("GET list Done ----------------------------------------------------------->");

        for (Employee e : resultList) {
            System.out.println("name : "+ e.getEname() + "  Department : "+ e.getDep().getName());
        }
    }
}
