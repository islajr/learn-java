package org.project.todoapp.model;

public enum Status {
    COMPLETED,
    STARTED,
    INCOMPLETE;

    public static Status toStatus(String stat) {
        for (Status status : Status.values()) {
            if (Status.valueOf(stat).name().equals(status.name()))
                return status;
        } return null;
    }
}

