package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.InputValidator;

public class CourseMenuUI extends MenuUI {
    private final CourseService courseService;

    public CourseMenuUI(CourseService courseService) {
        this.courseService = courseService;
    }

    public void show() throws InvalidInputException, EntityNotFoundException {
        String[] options = {
                "Add Course",
                "View All Courses",
                "Search Course by ID",
                "Activate/Deactivate Course"
        };

        while (true) {
            int choice = getMenuChoice(options);
            if (choice == 0) break;

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> courseService.listCourses();
                case 3 -> searchCourse();
                case 4 -> toggleCourseStatus();
            }
        }
    }

    private void addCourse() throws InvalidInputException {
        System.out.print("Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();

        int duration = InputValidator.getIntInput("Duration (weeks): ", 1, 52);
        courseService.addCourse(name, description, duration);
        System.out.println("  Course added successfully!");
    }

    private void searchCourse() throws EntityNotFoundException {
        int id = getIntInput("Enter Course ID: ");
        courseService.findCourseById(id);
    }

    private void toggleCourseStatus() throws EntityNotFoundException {
        int id = getIntInput("Enter Course ID: ");
        boolean newStatus = !courseService.isCourseActive(id);
        courseService.setCourseActive(id, newStatus);
        System.out.println("  Course status " + (newStatus ? "activated" : "deactivated") + "!");
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
        return "COURSE MENU";
    }
}
