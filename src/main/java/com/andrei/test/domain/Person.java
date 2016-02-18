package com.andrei.test.domain;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by totzh on 24.01.2016.
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable{
    private static final long serialVersionUID = -5527566248002296042L;

    public Person(){
        this.createdDate = new java.util.Date();
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "isADMIN")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean admin;

    @Column(name = "CreatedDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }





}
