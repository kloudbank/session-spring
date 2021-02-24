# session-spring
session architecture sample application using springboot


$ mvn package
$ docker build -t session-spring .
$ docker tag session-spring htdp1/session-spring:lastest
$ docker tag session-spring htdp1/session-spring:v2
$ docker push htdp1/session-spring:v2