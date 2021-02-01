FROM openjdk:12
COPY entrypoint/build/libs/entrypoint.jar entrypoint.jar

ENTRYPOINT ["java","-jar","/entrypoint.jar"]