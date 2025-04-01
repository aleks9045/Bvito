FROM openjdk:17-jdk-slim AS builder

WORKDIR /bvito

COPY mvnw .
COPY pom.xml .
COPY .mvn/ .mvn/

RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline -B

COPY . .

RUN ./mvnw package -DskipTests


FROM openjdk:17-jdk-slim

COPY --from=builder /bvito/target/Bvito-3.4.4.jar ./Bvito-3.4.4.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "./Bvito-3.4.4.jar"]
CMD ["--spring.profiles.active=prod", "-Xms256m", "-Xmx888m"]