package com.company.entity;


import javax.persistence.*;

import static com.company.QueryNames.GET_EMPLOYEE_BY_ID;


@Entity
@Table
@NamedQuery(query="select e from Employee e where e.eid = :id",name=GET_EMPLOYEE_BY_ID)
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long eid;
    private String ename;
    private double salary;
    private String deg;
    @OneToOne
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @ManyToOne
    @JoinColumn(name = "did")
    private Department dep;

    public Employee(String ename, double salary, String deg) {
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
    }

    public Employee() {
        super();
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
    }
}
