package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.StudentEntity;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<StudentEntity> students = new ArrayList<>();  // Dynamic collection

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        StudentEntity student = new StudentEntity(id, firstName, lastName, email, batch);
        students.add(student);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        students.stream()
                .filter(StudentEntity::isActive)
                .forEach(student ->
                        System.out.println(student.getId() + ": " + student.getFirstName()+student.getLastName()));
    }

    public StudentEntity findStudentById(int id) throws EntityNotFoundException {
        return students.stream()
                .filter(s -> s.getId() == id && s.isActive())
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student", id));
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        StudentEntity student = findStudentById(id);
        student.setActive(false);
    }
}
