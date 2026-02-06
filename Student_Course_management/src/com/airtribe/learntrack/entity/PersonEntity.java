package com.airtribe.learntrack.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PersonEntity {

//    @Column(name = "ID")
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;

    public PersonEntity(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
