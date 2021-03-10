package com.company.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;
    private String sname;

    public Staff(String sname) {
        this.sname = sname;
    }

    public Staff() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
