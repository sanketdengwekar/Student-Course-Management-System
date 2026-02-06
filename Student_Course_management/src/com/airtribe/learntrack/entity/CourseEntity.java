package com.airtribe.learntrack.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseEntity {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public CourseEntity(int id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = true;
    }
}
