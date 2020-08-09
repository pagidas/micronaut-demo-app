#!/bin/sh
docker build . -t micronaut-demo-app
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run --name micronaut-demo-app -p 8080:8080 micronaut-demo-app"

