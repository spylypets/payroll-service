FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} payroll-service.jar
ENTRYPOINT ["java","-jar","/payroll-service.jar"]
