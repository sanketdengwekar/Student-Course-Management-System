package com.airtribe.learntrack;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.*;
import com.airtribe.learntrack.ui.MainMenuUI;

public class StudentCourseManagement {
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();


    public static void main(String[] args) throws InvalidInputException, EntityNotFoundException {
        System.out.println("Student Management System" +System.currentTimeMillis());
        new MainMenuUI(studentService, courseService, enrollmentService).show();
    }


}
