#Action Monitor

The application has 3 component:

 - The bussiness application `betting-app`
 - The monitor application `monitor-webapp`
 - ActiveMQ message queue `message-queue`

##betting-app
###How to start
 `mvn spring-boot:run` in the `betting-app` directory
 or
 after `mvn package` run with `java -jar betting-app-1.0-SNAPSHOT.jar`
###API

#### Bet resource
##### Create
###### Request
```
POST /api/bet HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded

amount=200
```
###### Response 
```
{"id":1,"amount":200}
```

##### Update
###### Request
```
PUT /api/bet/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded

amount=300
```
###### Response 
```
{"id":1,"amount":300}
```


#### App Info
##### Ping
###### Request
```
GET http://localhost:8080 /api/app-info/ping
```
###### Response 
```
OK
```
##### Version
###### Request
```
GET http://localhost:8080 /api/app-info/version
```
###### Response 
```
1.0-SNAPSHOT
```

##monitor-webapp
###How to start
 `mvn spring-boot:run` in the `monitor-webapp` directory
 or
  after `mvn package` run with `java -jar monitoring-webapp-1.0-SNAPSHOT.jar`
###Usage
Open the http://localhost:8090/ url.


##message-queue
This is just to make it easy to start a test queue
###How to start
 `mvn activemq:run`