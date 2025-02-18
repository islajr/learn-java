
import java.nio.file.Path;
import java.util.ArrayList;

public class TaskManager {


    Path path = Path.of("./tasks.json");

    //  implementation methods
    public void addTask(String subject) {
        Task task = new Task(subject);
        
    }

    public void updateTask(int id, String subject) {

    }

    public void deleteTask(int id) {

    }

    public ArrayList<Task> listAll() {
        return null;
    }

    public ArrayList<Task> listByStatus(String status) {
        return null;
    }

    public void markInProgress(int id) {

    }

    public void markDone(int id) {

    }

}