# Use an official OpenJDK runtime as a parent image
FROM openjdk:19-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot application runs on (usually 8080)
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]
