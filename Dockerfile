FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD target/bookcatalogue-0.0.1-SNAPSHOT.jar bookcatalogue-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","bookcatalogue-0.0.1-SNAPSHOT.jar"]