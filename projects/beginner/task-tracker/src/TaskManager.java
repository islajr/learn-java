import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class TaskManager {

    final Path jsonFile = Path.of("./tasks.json");
    private ArrayList<Task> tasks;
    
    public TaskManager() {
       
    }

    public ArrayList<Task> loadTasks() {
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

    public ArrayList<Task> jsonToArray(String jsonTask) {
        ArrayList<Task> tasks = new ArrayList<>();
        
        //  preliminary json checker
        if (!jsonTask.startsWith("{") && jsonTask.endsWith("}")) {
            System.out.println("Error reading file!");
        } else {
            int counter = -1;   // starts at -1 to negate the effect of first bracket
            for (int i = 0; i <= jsonTask.length(); ++i) {
                if (Objects.equals(jsonTask.charAt(i), '{'))
                    counter++;
            }
            

            
        }
    }

    public String arrayToJson(ArrayList<Task> tasks) {  // converts list of tasks into a big file ready to be written
        String finalJson, eachTask = "";

        for (Task task : tasks) {
            eachTask = eachTask + "{" + task.toJson() + "}";
        }

        finalJson = "{" + eachTask + "}";
        return finalJson;
    }

    public void saveTask(String jsonTask) {
        // manually write the task to the file.
        try {
            Files.writeString(jsonFile, jsonTask);
        } catch (IOException e) {
            System.out.println("File does not exist");
        } catch (Exception e) {
            System.out.println("Something went wrong! ");
        }
    }

    public Task findTaskById(int id) {
        ArrayList<Task> tasks = loadTasks();
        
        // loop through list to find said id and return appropriate task or error.
        return null;
    }


    //  implementation methods
    public void addTask(String subject) {
        Task task = new Task(subject);
        String taskJson;
        ArrayList<Task> tasks = loadTasks();

        if (tasks.isEmpty()) {
            task.setId(1);
            taskJson = task.toJson();
            saveTask(taskJson);
        }
        else {  // if there are tasks present
            task.setId(loadTasks().size() + 1);
            tasks.add(task);
            // convert entire arraylist back to json
            // pass converted json file to saveTask()
        }

        
    }

    public void updateTask(int id, String subject) {
        // find task by id and update it.
        try {
            ArrayList<Task> tasks = loadTasks();
        } catch (Exception e) {
        }
    }

    public void deleteTask(int id) {
        // find task  by id, and delete it.
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