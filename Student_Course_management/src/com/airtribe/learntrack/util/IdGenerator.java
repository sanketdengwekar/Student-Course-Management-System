package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentCounter = 1;
    private static int courseCounter = 100;
    private static int enrollmentCounter = 1000;

    public static int getNextStudentId() {
        return studentCounter++;
    }

    public static int getNextCourseId() {
        return courseCounter++;
    }

    public static int getNextEnrollmentId() {
        return enrollmentCounter++;
    }
}
