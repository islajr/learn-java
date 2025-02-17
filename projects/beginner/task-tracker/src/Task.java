import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private final int id;
    public String subject;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public Task(String subject) {
        this.id = 1;
        this.subject = subject;
        this.status = "todo";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void updateSubject(String newSubject) {
        status = newSubject;
        updatedAt = LocalDateTime.now();
    }

    public void markDone() {
        status = "done";
        updatedAt = LocalDateTime.now();
    }

    public String parseTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        return time.format(formatter);
    }


    @Override
    public String toString() {
        return "id: " + id + " subject: " + subject + " status: " + status + " createdAt: " 
        + parseTime(createdAt) + " last updated: " + parseTime(updatedAt) + ".";
    }

    
}