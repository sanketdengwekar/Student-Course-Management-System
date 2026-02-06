package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.CourseEntity;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final List<CourseEntity> courses = new ArrayList<>();

    public void addCourse(String name, String description, int duration) {
        int id = IdGenerator.getNextCourseId();
        courses.add(new CourseEntity(id, name, description, duration));
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        courses.stream()
                .filter(CourseEntity::isActive)
                .forEach(CourseEntity ->
                        System.out.println(CourseEntity.getId() + ": " + CourseEntity.getCourseName()+CourseEntity.getDescription()));
    }

    public CourseEntity findCourseById(int id) throws EntityNotFoundException {
        return courses.stream()
                .filter(c -> c.getId() == id && c.isActive())
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course", id));
    }

    public boolean isCourseActive(int id) throws EntityNotFoundException {
        return findCourseById(id).isActive();
    }

    public void setCourseActive(int id, boolean active) throws EntityNotFoundException {
        CourseEntity course = findCourseById(id);
        course.setActive(active);
    }
}
