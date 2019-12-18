FROM openjdk:11-jdk-slim
WORKDIR /home/demo
COPY target/demo-testcontainers-0.0.1-SNAPSHOT.jar App.jar
ENTRYPOINT ["java", "-jar", "App.jar"]