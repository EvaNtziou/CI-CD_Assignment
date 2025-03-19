FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

COPY target/assignment-0.0.1-SNAPSHOT.jar assignment-0.0.1-SNAPSHOT.jar

#expose the port
EXPOSE 8080
#run the app
ENTRYPOINT ["java", "-jar", "assignment-0.0.1-SNAPSHOT.jar"] 