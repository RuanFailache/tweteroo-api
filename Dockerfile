FROM maven:3-amazoncorretto-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17 AS production
COPY --from=builder app/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT java -jar application.jar
