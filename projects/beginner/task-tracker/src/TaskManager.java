import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
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

    public void saveTask(ArrayList<Task> tasks) {   // saves an array list of tasks to json file.
        String jsonTask = arrayToJson(tasks);
        
        try {
            Files.writeString(jsonFile, jsonTask);
        } catch (IOException e) {
            System.out.println("COuld not write to file!");
        } catch (Exception e) {
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
        ArrayList<Task> tasks = loadTasks();

        if (tasks.isEmpty()) {
            task.setId(1);
        }
        else {  // if there are tasks present
            task.setId(tasks.size() + 1);
        }

        tasks.add(task);
        saveTask(tasks);
        System.out.println("Successfully added task! ");

        
    }

    public void updateTask(int id, String subject) {
        ArrayList<Task> tasks = loadTasks();

        // find task by id and update it.
        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.subject = subject;
                    task.updatedAt = LocalDateTime.now();
                    saveTask(tasks);
                    System.out.println("Successfully updated task #" + id + "! ");
                }
            }
        } else {
            System.out.println("No task to update! ");
        }
    }

    public void deleteTask(int id) {
        // find task  by id, and delete it.
        ArrayList<Task> tasks = loadTasks();

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    tasks.remove(tasks.indexOf(task));
                    System.out.println("Successfully deleted task #" + id + "! ");
                }
            }
        } else {
            System.out.println("No task to delete! ");
        }
    }

    public void listAll() {
        ArrayList<Task> tasks = loadTasks();

        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to list!");
        } else {
            for (Task task : tasks) {
                System.out.println(task.toString());    // will check this implementation later.
            }
        }
        
    }

    public void listByStatus(String status) {
        ArrayList<Task> tasks = loadTasks();

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.status.equals(status.strip())) {
                    System.out.println(task.toString());
                }
            }
        } else {
            System.out.println("There are no " + status.strip() + " tasks registered! ");
        }

    }

    public void markInProgress(int id) {
        // find task by id and change status
        ArrayList<Task> tasks = loadTasks();

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.status = "in-progress";
                    saveTask(tasks);
                    System.out.println("Successfully marked task #" + id + " as 'in-progress'");
                }
            }

        } else {
            System.out.println("There is no such task! ");
        }
    }

    public void markDone(int id) {
        ArrayList<Task> tasks = loadTasks();

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.status = "done";
                    saveTask(tasks);
                    System.out.println("Successfully marked task #" + id + " as 'done'");
                }
            }

        } else {
            System.out.println("There is no such task! ");
        }
    }

}