# CI-CD_Assignment
## How is this project built
This is a Spring Boot application written in Java. Maven has also been used as a build automation and project management tool. All of the data is stored in a relational SQLite DataBase named SDB.db.
## What this project does
This is a simple CRUD application that manages resource stock, including name, quantity and a unique auto-incrementing id. It uses a relational database - SQLite and exposes the required REST endpoints. It provides users with the basic functions of handling the resource stock. This includes accessing all of the resources, finding a specific one using its id, adding new resources and updating or deleting existing ones.
## Workflows and Testing
The code quality of this project is tested with Checkstyle. JUnit is also used for unit testing. The workflows can be viewed in [this  file](.github/workflows/ci.yml).
## How to clone the repository
in the command line, after you have navigated to the desired file, type the following:
1. git clone https://github.com/EvaNtziou/CI-CD_Assignment.git
2. cd your-repository
3. mvn install (if necessary to install dependencies)
   
And that's it!
