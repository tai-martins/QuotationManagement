FROM openjdk

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} quotation-management.jar

ENTRYPOINT ["java","-jar","/quotation-management.jar"]

SHELL ["/bin/sh", "-c"]

EXPOSE 8081

#CMD java ${ADDITIONAL_OPTS} -jar quotation-management.jar --spring.profiles.active=${PROFILE}


