FROM openjdk:17-jdk-slim AS builder

WORKDIR /bvito

COPY . .

RUN chmod +x /bvito/mvnw

RUN ./mvnw package

FROM openjdk:17-jdk-slim

COPY --from=builder /bvito/target/Bvito-3.4.4.jar ./Bvito-3.4.4.jar

EXPOSE 8000

CMD ["java", "-jar", "./Bvito-0.0.1-SNAPSHOT.jar"]