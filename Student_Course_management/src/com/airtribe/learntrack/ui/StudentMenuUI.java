package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentMenuUI extends MenuUI {
    private final StudentService studentService;

    public StudentMenuUI(StudentService studentService) {
        this.studentService = studentService;
    }

    public void show() throws EntityNotFoundException {
        String[] options = {
                "Add Student",
                "View All Students",
                "Search Student by ID",
                "Deactivate Student"
        };

        while (true) {
            int choice = getMenuChoice(options);
            if (choice == 0) break;

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> studentService.listStudents();
                case 3 -> searchStudent();
                case 4 -> deactivateStudent();
            }
        }
    }

    private void addStudent() {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        studentService.addStudent(firstName, lastName, email, batch);
        System.out.println(" Student added successfully!");
    }

    private void searchStudent() throws EntityNotFoundException {
        int id = getIntInput("Enter Student ID: ");
        studentService.findStudentById(id);
    }

    private void deactivateStudent() throws EntityNotFoundException {
        int id = getIntInput("Enter Student ID to deactivate: ");
        studentService.deactivateStudent(id);
        System.out.println(" Student deactivated!");
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
        return "STUDENT MENU";
    }
}
