FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-demo-app
WORKDIR /home/app/micronaut-demo-app

RUN native-image --no-server -cp build/libs/micronaut-demo-app-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-demo-app/micronaut-demo-app /app/micronaut-demo-app
ENTRYPOINT ["/app/micronaut-demo-app"]