public class TaskApp {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        if (args.length < 1) {
            System.out.println("Usage: TaskApp [command] id subject");
        }
        
        switch (args[0]) {
            case "add" -> {
                if (args.length == 2 && args[1] instanceof String) {
                   manager.addTask(args[1]); 
                }
                else
                    System.out.println("Usage: TaskApp [command] id subject");
                
            }
            
            case "update" -> {
                try {
                    manager.updateTask(args[2]);
                } catch (Exception e) {
                    System.out.println("There was a problem");
                    System.out.println("Usage: TaskApp [command] id subject");
                }
            }

            case "delete" -> {
                try {
                    int taskId = Integer.parseInt(args[1]);
                    manager.deleteTask(taskId);
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a number.");
                } catch (Exception e) {
                    System.out.println("Could not delete non-existent task.");
                }
            }

            case "list" -> {
                if (args.length == 1 && args[0].equals("list")) {
                    manager.listAll();
                } else if (args.length == 2) {
                    try {
                        manager.listByStatus(args[1]);
                    } catch (Exception e) {
                        System.out.println("Something went wrong! ");
                    }
                }
            }

            case "mark-in-progress" -> {
                try {
                    int taskId = Integer.parseInt(args[1]);
                    manager.markInProgress(taskId);
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a task id");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }
        
            case "mark-done" -> {
                try {
                    int taskId = Integer.parseInt(args[1]);
                    manager.markDone(taskId);
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a task id");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            default -> {
                System.out.println("Usage: TaskApp [command] id subject");
            }
        }

    }
}