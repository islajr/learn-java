import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TaskManager {

    final Path jsonFile = Path.of("./tasks.json");
    private ArrayList<Task> tasks;
    

    // no args constructor
    public TaskManager() {
       
    }

    public ArrayList<Task> loadTasks() {    // reads from json file and converts it into an array
        ArrayList<Task> tasks = new ArrayList<>();

        if (!Files.exists(jsonFile)) {
            // create with filesystem command
        }

        try {
            String fileContent = Files.readString(jsonFile);
            
            if (!fileContent.isEmpty()) {
                // manually read and convert it into an array of tasks.

                int start = 0;
                int stop = 0;
                for (int i = 1; i <= fileContent.length() - 1; ++i) {
                    if (fileContent.charAt(i) == '{') {
                        start = i;

                    } if (fileContent.charAt(i) == '}') {
                        stop = i;
                    }

                    try {
                        String jsonTask = fileContent.substring(start, stop);
                        Task task = new Task();
                        task = task.fromJson(jsonTask);
                        tasks.add(task);
                    } catch(Exception e ) {
                        System.out.println("Something went wrong!");
                    }
                }
                
            } else {
                return tasks;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }

        return tasks;
    }

    public String arrayToJson(ArrayList<Task> tasks) {  // converts list of tasks into a big file ready to be written
        String finalJson, eachTask = "";

        for (Task task : tasks) {
            eachTask = eachTask + "{" + task.toJson() + "}";
        }

        finalJson = "{" + eachTask + "}";
        return finalJson;
    }

   /*  public void saveTask(String jsonTask) {
        // manually write the task to the file.
        try {
            Files.writeString(jsonFile, jsonTask);
        } catch (IOException e) {
            System.out.println("File does not exist");
        } catch (Exception e) {
            System.out.println("Something went wrong! ");
        }
    } */

    public void saveTask(ArrayList<Task> tasks) {   // saves an array list of tasks to json file.
        String jsonTask = arrayToJson(tasks);
        
        try {
            Files.writeString(jsonFile, jsonTask);
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public Task findTaskById(int id) {
        ArrayList<Task> tasks = loadTasks();
        
        // loop through list to find said id and return appropriate task or error.

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    return task;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
                return null;

    }


    //  implementation methods
    public void addTask(String subject) {
        Task task = new Task(subject);
        String taskJson;
        ArrayList<Task> tasks = loadTasks();

        if (tasks.isEmpty()) {
            task.setId(1);
        }
        else {  // if there are tasks present
            task.setId(tasks.size() + 1);
        }

        tasks.add(task);
        saveTask(tasks);

        
    }

    public void updateTask(int id, String subject) {
        // find task by id and update it.
        try {
            Task task = findTaskById(id);
            task.subject = subject;
            System.out.println(task.toString());
        } catch (Exception e) {
            System.out.println("There was a problem! ");
        }
    }

    public void deleteTask(int id) {
        // find task  by id, and delete it.
        Task task = findTaskById(id);

        if (task == null) {
            System.out.println("No such task! ");
        } else {

        }
    }

    public ArrayList<Task> listAll() {
        return null;
    }

    public ArrayList<Task> listByStatus(String status) {
        return null;
    }

    public void markInProgress(int id) {
        // find task by id and change status
    }

    public void markDone(int id) {

    }

}