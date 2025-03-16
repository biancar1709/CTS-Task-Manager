# CTS-Task-Manager

The code shall be version in git and pushed in a public repository within the tool of your
choice: GitHub, GitLab, BitBucket, Azure Repos etc. Upload in the assignment a link to the
created repo where the code will be versioned, even though the code may not be ready yet.
Task Manager:
General rules:
Code smells to watch out for:
The task manager shall hold multiple tasks, each associated to a user
There are 2 types of Users: ADMIN and REGULAR
Regular users shall not be able to delete tasks
Users can create multiple tasks with title, description, unique identifier (generated)
Users can update and delete the task
Users can hide and unhide a task
Users can see all visible tasks
Admins can see all tasks
User can filter out tasks based on a criteria of your choice
Write a minimal CLI interface (e.g. : press 1 to create user, press 2 to choose user, press
3 to create task etc)
DRY
KISS
YAGNI
SOLID
Respect variable naming conventions
Respect indentation styles
Keep a tidy workspace
Bloaters
Complicated ifs/switches
Unused fields
Divergent change / Shotgun surgery
Dispensable code
Feature envy
Inappropriate Intimacy
Message chain / Middle man
