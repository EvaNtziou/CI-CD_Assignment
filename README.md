
# CI/CD Assignment - Spring Boot Application
## Project Overview
This is a simple Spring Boot REST API that demonstrates CI/CD automation. The project includes:

A RESTful API for managing resources (name, quantity, id)

Docker support for containerization

GitHub Actions for CI/CD

Deployment-ready build

## Technologies Used
Java 17

Spring Boot

Maven

Docker

GitHub Actions

## Project Structure
Typical structure of a simple cicd springboot project

## Setup Instructions
1. git clone https://github.com/EvaNtziou/CI-CD_Assignment.git
2. cd your-repository

## Build the Project
Ensure you have Java 17 and Maven installed.
1. mvn clean package
After a successful build, the JAR file will be in the target/ directory:
target/assignment-0.0.1-SNAPSHOT.jar

## Run Locally
java -jar target/assignment-0.0.1-SNAPSHOT.jar
The application should now be running on http://localhost:8080

## Run with Docker
1. Build the Docker Image
docker build -t docker-username/cicd_assign:latest .
2. Run the Container
docker run -p 8080:8080 docker-username/cicd_assign:latest
3. Push Docker Image to Docker Hub
A. docker login
B. docker tag docker-username/cicd_assign:latest docker-username/repo-name:latest
C. docker push docker-username/repo-name:latest

## CI/CD with GitHub Actions
This project uses GitHub Actions to automate testing and deployment. The pipeline:

Runs on every push to main
Builds the project with Maven
Creates a Docker image
Pushes the image to Docker Hub

 [Workflow file docker ](.github/workflows/docker.yml)
[Workflow file ci ](.github/workflows/ci.yml)

## API Endpoints
Method	Endpoint	Description
GET	/api/resources	Get all resources
GET	/api/resources/{id}	Get resource by ID
POST	/api/resources	Create a new resource
PUT	/api/resources/{id}	Update a resource
DELETE	/api/resources/{id}	Delete a resource
