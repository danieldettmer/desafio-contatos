FROM openjdk:8-jre-alpine
RUN apk --update add --no-cache bash
RUN rm -Rf /var/cache/apk/*
RUN mkdir -p /app
ENV PROJECT_HOME /app
COPY out/artifacts/desafio_contatos_jar $PROJECT_HOME
WORKDIR $PROJECT_HOME
EXPOSE 8080
CMD ["java", "-jar", "./desafio-contatos.jar"]