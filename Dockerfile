FROM openjdk:8-jdk-slim as runtime
MAINTAINER Datawire <dev@datawire.io>
LABEL PROJECT_REPO_URL         = "git@github.com:datawire/???.git" \
      PROJECT_REPO_BROWSER_URL = "https://github.com/datawire/???" \
      DESCRIPTION              = "Datawire Labs - Hello Spring Boot!" \
      VENDOR                   = "Datawire, Inc." \
      VENDOR_URL               = "https://datawire.io"

ENV TERM=dumb

WORKDIR /srv
COPY    . .
RUN     ./gradlew test build

ENTRYPOINT ["java"]
CMD ["-jar", "build/libs/hello-forge-springboot-0.0.1-SNAPSHOT.jar"]
