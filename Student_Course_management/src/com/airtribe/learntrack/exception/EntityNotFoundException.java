package com.airtribe.learntrack.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entity, int id) {
        super(entity + " does not exist for id " + id );
    }
}
