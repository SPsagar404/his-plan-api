FROM openjdk:8
EXPOSE 8080
ADD target/plan-api.jar spring-boot-mysql.jar
ENTRYPOINT ["java","-jar","/plan-api.jar"]