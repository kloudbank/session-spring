# session-spring
session architecture sample application using springboot

# maven build & docker build/push
```
mvn clean package
docker build -t session-spring .
docker tag session-spring htdp1/session-spring:v1
docker push htdp1/session-spring:v1
docker tag session-spring htdp1/session-spring:latest
docker push htdp1/session-spring:latest
```
