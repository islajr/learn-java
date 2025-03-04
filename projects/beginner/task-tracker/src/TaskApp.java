public class TaskApp {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        if (args.length < 1) {
            System.out.println("Usage: TaskApp <command> [arguments]");
        }
        
        switch (args[0]) {
            case "add" -> {
                if (args.length <= 2) {
                    try {
                        manager.addTask(args[1]); 
                     }
                     catch (Exception e) {
                        // e.printStackTrace();
                         System.out.println("Failed to add task!");
                     }
                } else {
                    System.out.println("Usage: TaskApp <command> [arguments]");
                }
               
            }
            
            case "update" -> {
                if (args.length <= 3) {
                    try {
                        int taskId = Integer.parseInt(args[1]);
                        manager.updateTask(taskId, args[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide a valid task id!");
                    } catch (Exception e) {
                        System.out.println("Update action failed!");
                    }
                } else{ 
                    System.out.println("Usage: TaskApp <command> [arguments]");
                }
            }

            case "delete" -> {
                if (args.length <= 2) {
                    try {
                        int taskId = Integer.parseInt(args[1]);
                        manager.deleteTask(taskId);
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide a number.");
                    } catch (Exception e) {
                        System.out.println("Could not delete non-existent task!");
                    }
                } else {
                    System.out.println("Usage: TaskApp <command> [arguments]");
                }
            }

            case "list" -> {
            switch (args.length) {
                case 1 -> {
                    if (args[0].equals("list")) {
                        manager.listAll();
                    } else {
                        System.out.println("Usage: TaskApp <command> [arguments]");
                    }
                }
                case 2 -> {
                    try {
                        manager.listByStatus(args[1]);
                    } catch (Exception e) {
                        System.out.println("Failed to list tasks!");
                    }
                }
                default -> System.out.println("Usage: TaskApp <command> [arguments]");
            }
            }

            case "mark-in-progress" -> {
                if (args.length <= 2) {
                    try {
                        int taskId = Integer.parseInt(args[1]);
                        manager.markInProgress(taskId);
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide a task id");
                    } catch (Exception e) {
                        System.out.println("Failed to mark as in-progress!");
                    }
                } else {
                    System.out.println("Usage: TaskApp <command> [arguments]");
                }
                
            }
        
            case "mark-done" -> {
                if (args.length <= 2) {
                    try {
                        int taskId = Integer.parseInt(args[1]);
                        manager.markDone(taskId);
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide a task id");
                    } catch (Exception e) {
                        System.out.println("Failed to mark as done!");
                    }
                } else {
                    System.out.println("Usage: TaskApp <command> [arguments]");
                }
                
            }

            case "clear" -> {
                if (args.length == 1 && args[0].equals("clear")) {
                    manager.clear();
                } else {
                    System.out.println("Usage: TaskApp <command> [arguments]");
                }
            }

            default -> {
                System.out.println("Usage: TaskApp <command> [arguments]");
            }
        }

    }
}