FROM openjdk:17
EXPOSE 8080
ADD target/student-crud-operations-sample.jar student-crud-operations-sample.jar
ENTRYPOINT ["java","-jar","/student-crud-operations-sample.jar"]