# /!\ do NOT mix stable + edge! /!\
FROM alpine:edge

WORKDIR /root

VOLUME ["/root/project"]

# testing is not enabled by default
RUN echo 'https://dl-cdn.alpinelinux.org/alpine/edge/testing/' >> /etc/apk/repositories

# install
RUN apk add --no-cache sbt openjdk8

# sbt should use global cache, so let's download some shit... it will need to happen anyway
# /!\ this takes ages... /!\
RUN sbt scalaVersion

ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk PATH="${JAVA_HOME}/bin:${PATH}"

# default for play (scala)
EXPOSE 9000

# vim: set expandtab ft=dockerfile:
