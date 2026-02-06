package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.InputValidator;

public class EnrollmentMenuUI extends MenuUI {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public EnrollmentMenuUI(StudentService studentService, CourseService courseService,
                            EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    public void show() throws EntityNotFoundException, InvalidInputException {
        String[] options = {
                "Enroll Student in Course",
                "View Student Enrollments",
                "View Course Enrollments",
                "Update Enrollment Status"
        };

        while (true) {
            int choice = getMenuChoice(options);
            if (choice == 0) break;

            switch (choice) {
                case 1 -> enrollStudent();
                case 2 -> viewStudentEnrollments();
                case 3 -> viewCourseEnrollments();
                case 4 -> updateEnrollmentStatus();
            }
        }
    }

    private void enrollStudent() throws EntityNotFoundException {
        int studentId = getIntInput("Enter Student ID: ");
        studentService.findStudentById(studentId);

        int courseId = getIntInput("Enter Course ID: ");
        courseService.findCourseById(courseId);

        enrollmentService.enrollStudent(studentId, courseId);
        System.out.println(" Student enrolled successfully!");
    }

    private void viewStudentEnrollments() {
        int studentId = getIntInput("Enter Student ID: ");
        enrollmentService.listStudentEnrollments(studentId);
    }

    private void viewCourseEnrollments() {
        int courseId = getIntInput("Enter Course ID: ");
        enrollmentService.listCourseEnrollments(courseId);
    }

    private void updateEnrollmentStatus() throws InvalidInputException, EntityNotFoundException {
        int enrollmentId = getIntInput("Enter Enrollment ID: ");
        System.out.println("1. ACTIVE | 2. COMPLETED | 3. CANCELLED");

        int statusChoice = InputValidator.getIntInput("Status: ", 1, 3);
        String status = switch (statusChoice) {
            case 1 -> "ACTIVE";
            case 2 -> "COMPLETED";
            case 3 -> "CANCELLED";
            default -> throw new IllegalArgumentException("Invalid status");
        };

        enrollmentService.updateEnrollmentStatus(enrollmentId, status);
        System.out.println(" Enrollment status updated!");
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number.");
            }
        }
    }

    @Override
    protected String getMenuTitle() {
        return "ENROLLMENT MENU";
    }
}
