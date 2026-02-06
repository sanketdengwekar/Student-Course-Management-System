package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.EnrollmentEntity;
import com.airtribe.learntrack.enums.Status;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentService {
    private final List<EnrollmentEntity> enrollments = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        enrollments.add(new EnrollmentEntity(id, studentId, courseId));
    }

    public void listStudentEnrollments(int studentId) {
        List<EnrollmentEntity> studentEnrollments = enrollments.stream()
                .filter(e -> e.getStudentId() == studentId)
                .collect(Collectors.toList());

        if (studentEnrollments.isEmpty()) {
            System.out.println("No enrollments for Student " + studentId);
            return;
        }

        studentEnrollments.forEach(System.out::println);
    }

    public void listCourseEnrollments(int courseId) {
        List<EnrollmentEntity> courseEnrollments = enrollments.stream()
                .filter(e -> e.getCourseId() == courseId)
                .collect(Collectors.toList());

        if (courseEnrollments.isEmpty()) {
            System.out.println("No enrollments for Course " + courseId);
            return;
        }

        courseEnrollments.forEach(System.out::println);
    }

    public void updateEnrollmentStatus(int enrollmentId, String status)
            throws EntityNotFoundException {
        EnrollmentEntity enrollment = enrollments.stream()
                .filter(e -> e.getId() == enrollmentId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Enrollment", enrollmentId));

        enrollment.setStatus(Status.valueOf(status));
    }
}
