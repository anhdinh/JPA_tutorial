package com.company.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    private String tName;
    private String subject;
    @ManyToMany(targetEntity = Class.class)
    @JoinTable(name = "class_teacher", joinColumns =
    @JoinColumn(name = "tid"), inverseJoinColumns = @JoinColumn(name = "cid"))
    private Set classSet;

    public Teacher(String tName, String subject) {
        this.tid = tid;
        this.tName = tName;
        this.subject = subject;
    }

    public Teacher() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set getClassSet() {
        return classSet;
    }

    public void setClassSet(Set classSet) {
        this.classSet = classSet;
    }
}
