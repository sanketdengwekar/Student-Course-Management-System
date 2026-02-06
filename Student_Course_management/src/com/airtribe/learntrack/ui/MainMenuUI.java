package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

public class MainMenuUI extends MenuUI {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public MainMenuUI(StudentService studentService, CourseService courseService,
                      EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    public void show() throws EntityNotFoundException, InvalidInputException {
        String[] options = {
                "Student Management",
                "Course Management",
                "Enrollment Management"
        };

        while (true) {
            int choice = getMenuChoice(options);
            switch (choice) {
                case 1 -> new StudentMenuUI(studentService).show();
                case 2 -> new CourseMenuUI(courseService).show();
                case 3 -> new EnrollmentMenuUI(studentService, courseService, enrollmentService).show();
                case 0 -> {
                    System.out.println("Thank you for using LearnTrack! ");
                    return;
                }
            }
        }
    }

    @Override
    protected String getMenuTitle() {
        return "MAIN MENU";
    }
}
