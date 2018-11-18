package com.wcc.threadtest.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;
    String fName;
    String surName;
    Date birthDay;
    @OneToMany
    List<Document> document = new ArrayList<>();

    @OneToMany
    List<Citizen> citizen = new ArrayList<>();

    @OneToOne
    Detail info;


}
