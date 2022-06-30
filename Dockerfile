FROM openjdk:8
COPY ./target/emr-spring-app.jar emr-spring-app.jar
EXPOSE 8070
CMD ["java","-jar","emr-spring-app.jar"]