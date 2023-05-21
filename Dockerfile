FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . /app

EXPOSE 8080
CMD ["java", "-jar", "/app/target/mdm_project_two-0.0.1-SNAPSHOT.jar"]