FROM amazoncorretto:21-alpine-jdk

ARG PROFILE
ENV PROFILE=${PROFILE}

COPY build/libs/*.jar app.jar

EXPOSE 8080 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=${PROFILE}"]
