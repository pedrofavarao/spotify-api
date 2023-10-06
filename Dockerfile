FROM openjdk:19
WORKDIR /app
COPY target/*.jar /app/api.jar
EXPOSE 2595:2595
CMD ["java", "-jar", "api.jar"]
