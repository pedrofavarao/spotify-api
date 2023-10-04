FROM openjdk:19
WORKDIR /app
COPY target/*.jar /app/api.jar
EXPOSE 8090:8090
CMD ["java", "-jar", "api.jar"]
