FROM openjdk:17-alpine
ARG JAR_FILE=tribe-task-app/target/tribe-task-app-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY $JAR_FILE sample.jar
ENTRYPOINT ["java", "-jar","sample.jar"]