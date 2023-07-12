FROM registry.access.redhat.com/ubi8/openjdk-11:1.14
EXPOSE 8090
RUN mkdir -p /opt/app
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} /opt/app/app.jar
WORKDIR /opt/app/
ENTRYPOINT ["java","-jar","app.jar", "--spring.data.mongodb.uri=mongodb://mongodb-ops-manager:Devdbpass2023@mongodb-dev-ops-manager-db-0.mongodb-dev-ops-manager-db-svc.mongodb-workspace.svc.cluster.local:27017,mongodb-dev-ops-manager-db-1.mongodb-dev-ops-manager-db-svc.mongodb-workspace.svc.cluster.local:27017,mongodb-dev-ops-manager-db-2.mongodb-dev-ops-manager-db-svc.mongodb-workspace.svc.cluster.local:27017/?authMechanism=SCRAM-SHA-256&authSource=admin&connectTimeoutMS=20000&replicaSet=mongodb-dev-ops-manager-db&serverSelectionTimeoutMS=20000", "--springdoc.api-docs.path=/zaga-openapi", "--server.port=8090"]