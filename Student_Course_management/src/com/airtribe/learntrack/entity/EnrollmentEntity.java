package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EnrollmentEntity {

    private int id;
    private int studentId;
    private int courseId;
    private LocalDateTime enrollmentDate;
    private Status status;

    public EnrollmentEntity(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDateTime.now();
        this.status = Status.ACTIVE;
    }
}

