FROM openjdk:11
EXPOSE 8080
MAINTAINER josemtm2002@gmail.com
ADD target/spring-challenge.jar spring-challenge.jar
ENTRYPOINT ["java","-jar","/spring-challenge.jar"]