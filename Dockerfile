FROM openjdk:17
LABEL maintainer ="branchEmpTracker"
ADD target/branchemptracker-docker.jar branchEmpTracker.jar
ENTRYPOINT [ "java","-jar","branchEmpTracker.jar" ]