# Task-Manager

Allows user to add tasks, delete them, and list them all in one place.

## The Problem

There are many assignments for different classes posted in different places. I want one place where I can manage and keep track of everything.

## How It Works

The software manages a list of the users tasks. Users can add, delete, and list them.
When adding, the list will automatically place the tasks in the correct location based on due date
When the user is done, the list is saved to a csv file so that it can be resumed later.

![System diagram](docs/System%20Diagram.pdf)

## Tech Stack

- **Language:** Java
- **Libraries:** ArrayList, IO, and LocalDate
- **External tools:** csv file

## Setup

Run the project and follow the onscreen instructions.

```bash
git https://github.com/tannerkinne/Task-Manager.git
cd Task-Manager
java Task-Manager
```

## Build Plan

- Set up github repo and connect to IDE.
- Create task class, tracking properties like name, due date, notes, etc.
- Create a list class, which creates an arraylist of tasks and allows adding at end, deletion of an item, and printing of list
- Edit addition function to add items at the proper sorted location in the list(based on due date) instead of adding at end
- Add function to save the list to a csv file when the user is done, and read the csv file to create an initial list when the user begins

## Roadmap

![Eisenhower Matrix](docs/Eisenhower%20Matrix.pdf)

- [ ] junit testing
- [ ] multiple accounts and lists
- [ ] custom list sorting

## Author

Tanner Kinne
https://github.com/tannerkinne