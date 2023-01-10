FROM openjdk:17-alpine
COPY ["target/*.jar", "app.jar"]
EXPOSE 8080 5005
ENTRYPOINT ["java","-jar","app.jar"]