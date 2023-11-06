FROM maven:3.8.5-openjdk-17

WORKDIR /
COPY . .
RUN mvn clean install

CMD java -jar application/target/application-1.0.0-SNAPSHOT.jar