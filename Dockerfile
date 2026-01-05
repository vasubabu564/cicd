FROM eclipse-temurin:21-jre

WORKDIR /usr/app

COPY target/cicd-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 7788

ENTRYPOINT ["java","-jar","app.jar"]
