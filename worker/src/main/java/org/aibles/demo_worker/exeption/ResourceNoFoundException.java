package org.aibles.demo_worker.exeption;

public class ResourceNoFoundException extends RuntimeException{
    private final String message;

    public ResourceNoFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
