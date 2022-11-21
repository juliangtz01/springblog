package com.example.springblog.models;

import jakarta.persistence.*;

import javax.lang.model.element.NestingKind;

@Entity
@Table(name = "owners")
public class Owner
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

}
