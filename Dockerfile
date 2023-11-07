FROM openjdk:21
COPY ./out/production/test_java/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","com.exmaple.test.Test"]