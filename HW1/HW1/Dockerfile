FROM maven:3.8.5-openjdk-17

WORKDIR /HW1

COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run