# Task Tracker

This is a CLI Application for tracking and managing tasks. The available functions include the following:

- Adding, Updating, and Deleting tasks.
- Marking a task as 'in progress' or 'done'.
- Listing all tasks
- Listing all 'done' tasks.
- Listing all undone tasks.
- Listing all tasks that are 'in progress'.

## Installation

**1. Clone the repository:**
    `git clone https://github.com/islajr/learn-java/tree/main/projects/beginner/task-tracker`

**2. Compile the code:**
   `cd task-tracker/src/`
   `javac *.java`

**3. Use the application with the prompt:**
   `java TaskApp <command> [arguments]`

## Usage

```
# adding new tasks
java TaskApp add "some task"

# updating a class
java TaskApp update 1 "some other task"

# marking a task as in-progress
java TaskApp mark-in-progress 1

# marking a task as done
java TaskApp mark-done 1

# listing all tasks
java TaskApp list

# listing tasks by status
java TaskApp list [todo in-progress done]

# deleting a task
java TaskApp delete 1
```