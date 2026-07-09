FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/bpmnserver-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "--add-opens", "java.base/java.util=ALL-UNNAMED", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", "-jar", "/app.jar"]


## Build Java
#mvn clean package -DskipTest
#
## Build Docker Image
#docker build -t bpmnserver:1.0 .
#
## Run
# kubectl apply -f bpmnserver.yaml
#
## Push
# kubectl apply -f bpmnserver-service.yaml

#kubectl rollout restart deployment bpmnserver
