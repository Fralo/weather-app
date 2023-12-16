FROM openjdk:21 AS builder

COPY ./src/ /tmp/src
WORKDIR /tmp
RUN javac -d ./out ./src/com/exmaple/test/* -Xlint:deprecation

FROM builder AS runner
COPY --from=builder /tmp/out /tmp/out
WORKDIR /tmp/out

ENTRYPOINT ["java", "it.unifi.weatherapp.WeatherEngineSimulator"]
