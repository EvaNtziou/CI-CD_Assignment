FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app
ARG JAR_FILE=target/assignment-0.0.1-SNAPSHOT.jar

# Step 3: Copy the JAR file from the local file system into the Docker image
COPY ${JAR_FILE} assignment.jar

#expose the port
EXPOSE 8080
#run the app
ENTRYPOINT ["java", "-jar", "assignment.jar"] 