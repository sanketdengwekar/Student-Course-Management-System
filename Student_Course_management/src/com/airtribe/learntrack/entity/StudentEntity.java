package com.airtribe.learntrack.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentEntity extends PersonEntity {

    private String batch;
    private boolean active;

    public StudentEntity(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);  // Inheritance
        this.batch = batch;
        this.active = true;
    }


}
