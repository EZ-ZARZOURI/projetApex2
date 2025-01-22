# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and the source code
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the project JAR file from the build stage
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar /app/backend.jar


# Make port 8082 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["sh", "-c", "sleep 60 && java -jar /app/backend.jar"]

