import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    public String subject;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public Task(String subject) {
        this.subject = subject;
        this.status = "todo";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Task() {
        
    }

    static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    // static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
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

    public void markInProgress() {
        status = "in-progress";
        updatedAt = LocalDateTime.now();
    }

    /* public String parseTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        return time.format(formatter);
    } */

    public String toJson() {
        return "{\"id\": " + id + ", \"subject\": \"" + subject + "\", \"status\": \"" +  status + "\", \"createdAt\": \"" + 
        createdAt.format(formatter) + "\", \"lastUpdated\": \"" + updatedAt.format(formatter) + "\"}";
    }

    public static Task fromJson(String jsonTask) {

        jsonTask = jsonTask.replace("{", "").replace("}", "").replace("\"", "");
        String[] jsonArray = jsonTask.split(",");

        String id = jsonArray[0].split(":")[1].strip();
        String subject = jsonArray[1].split(":")[1].strip();
        String status = jsonArray[2].split(":")[1].strip();
        String createdAt = jsonArray[3].split(": ")[1].strip();
        String lastUpdated = jsonArray[4].split(": ")[1].strip();

        Task task = new Task(subject);

        task.id = Integer.parseInt(id);
        task.status = status;
        task.createdAt = LocalDateTime.parse(createdAt, formatter);
        task.updatedAt = LocalDateTime.parse(lastUpdated, formatter);

        return task;
    }


    @Override
    public String toString() {
        return "id: " + id + " subject: " + subject + " status: " + status + " createdAt: " 
        + createdAt.format(formatter) + " lastUpdated: " + updatedAt.format(formatter) + ".";
    }

    
}