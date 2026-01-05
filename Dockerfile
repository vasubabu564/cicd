FROM eclipse-temurin:21-jre

WORKDIR /usr/app

COPY target/cicd-app.jar cicd-app.jar

EXPOSE 7788

ENTRYPOINT ["java","-jar","cicd-app.jar"]
