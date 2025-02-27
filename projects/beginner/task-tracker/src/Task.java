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

    public String parseTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        return time.format(formatter);
    }

    public String toJson() {
        return "{\"id\": " + id + ",\n\"subject\": \"" + subject + "\",\n\"status\": \"" +  status + "\",\n\"createdAt\": \"" + 
        parseTime(createdAt) + "\",\n\"lastUpdated\": \"" + parseTime(updatedAt) + "\"}";
    }

    public Task fromJson(String jsonTask) {

        jsonTask = jsonTask.replace("{", "").replace("}", "").replace("\n", ",");
        String[] jsonArray = jsonTask.split(",");

        String id = jsonArray[0].split(":")[1].strip();
        String subject = jsonArray[1].split(":")[1].strip();
        String status = jsonArray[2].split(":")[1].strip();
        String createdAt = jsonArray[3].split("[a-z]:")[1].strip();
        String lastUpdated = jsonArray[4].split("[a-z]:")[1].strip();

        Task task = new Task(subject);

        task.id = Integer.parseInt(id);
        task.status = status;
        task.createdAt = LocalDateTime.parse(createdAt);
        task.updatedAt = LocalDateTime.parse(lastUpdated);

        return task;
    }


    @Override
    public String toString() {
        return "id: " + id + " subject: " + subject + " status: " + status + " createdAt: " 
        + parseTime(createdAt) + " lastUpdated: " + parseTime(updatedAt) + ".";
    }

    
}