FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} timesheet-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/timesheet-0.0.1-SNAPSHOT.jar"]