# Task-Manager

Allows user to add tasks, delete them, and list them all in one place.

## The Problem

There are many assignments for different classes posted in different places. I want one place where I can manage and keep track of everything.

## How It Works

The application uses an ArrayList to store tasks. Each task contains a name, due date, and notes.

Users can:
- Add new tasks.
- Delete existing tasks.
- View their current tasks.
- Automatically organize tasks by due date.
- Save their task list to a CSV file when exiting.
- Load previously saved tasks when restarting the application.

### System Architecture
![System diagram](docs/System%20Diagram.pdf)

## Tech Stack

- **Language:** Java
- **Libraries:** ArrayList, Java I/O, LocalDate
- **Data Storage:** CSV file (`list.csv`)
- **Development Tools:** IntelliJ IDEA, Git, GitHub
## Setup

### Prerequisites

- Java JDK 8 or newer
- Git
- Terminal or command prompt

### Installation

1. Clone the repository:

```bash
git clone https://github.com/tannerkinne/Task-Manager.git
cd Task-Manager
```

2. Compile the Java files:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

3. Run the application:

```bash
java -cp out Task_Manager
```

### Example Usage

The following is an example of the application's intended workflow:

**Input:**
- Add a task named "Calculus Homework"
- Due date: 2026-12-01
- Notes: "Complete problems 1-20"

**Expected result:**
- Task is added successfully.
- Task appears in the list, sorted by due date.
- Task is saved to `list.csv` upon exiting.
- Task is restored when the application is launched again.

**![Example](docs/TaskManager_Example.pdf)**

## Build Plan

- Set up github repo and connect to IDE.
- Create task class, tracking properties like name, due date, notes, etc.
- Create a list class, which creates an arraylist of tasks and allows adding at end, deletion of an item, and printing of list
- Edit addition function to add items at the proper sorted location in the list(based on due date) instead of adding at end
- Add function to save the list to a csv file when the user is done, and read the csv file to create an initial list when the user begins

## Roadmap

![Eisenhower Matrix](docs/Eisenhower%20Matrix.pdf)

### Completed

- [x] Set up GitHub repository and connect it to IDE.
- [x] Create Task class with name, due date, and notes.
- [x] Create TaskList class using ArrayList.
- [x] Implement task addition and deletion.
- [x] Implement task listing.
- [x] Automatically sort tasks by due date.
- [x] Implement CSV file saving and loading.
- [x] Implement JUnit testing.

### Future Improvements


- [ ] Support multiple accounts and task lists.
- [ ] Allow custom task sorting.

## Author

Tanner Kinne
https://github.com/tannerkinne