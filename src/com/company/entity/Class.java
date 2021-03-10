package com.company.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;

    @ManyToMany(targetEntity = Teacher.class)
    @JoinTable(name = "class_teacher", joinColumns =
    @JoinColumn(name = "cid"), inverseJoinColumns = @JoinColumn(name = "tid"))
    private Set teacher;

    public Class(String name) {
        this.name = name;
    }

    public Class() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getTeacher() {
        return teacher;
    }

    public void setTeacher(Set teacher) {
        this.teacher = teacher;
    }
}
