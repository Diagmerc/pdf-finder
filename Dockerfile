FROM anapsix/alpine-java
MAINTAINER pdf-finder
COPY pdf-finder-0.0.1-SNAPSHOT.jar /pdf-finder-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/pdf-finder-0.0.1-SNAPSHOT.jar"]