public class Task {

    private Long id;
    public String subject;
    public String status;

    public Task(String subject) {
        this.id = id;
        this.subject = subject;
        this.status = "to do";
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void updateSubject(String newSubject) {
        status = newSubject;
    }

    public void markDone() {
        status = "done";
    }

    @Override
    public String toString() {
        return "id: " + id + " subject: " + subject + " status: " + status + ".";
    }

}