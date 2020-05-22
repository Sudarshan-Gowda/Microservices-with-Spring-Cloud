# Microservices-with-Spring-Cloud
Microservices with Spring Boot and Spring Cloud

## What is Microservices?	
<ul><li>Micro services is a small autonomous services that work together.</li>
<li>It can also be defined as a bare minimum of centralized management of these services, which may be written in different programming language and use different data storage technologies.</li>
</ul>  

### Topics Covered
<ul>
  <li>Feign</li>
  <li>Ribbon</li>
  <li>Eureka Naming Server</li>
  <li>API Gateway(Zuul)</li>
  <li>Distributed Tracing(Zipkin)</li>
   <li>Spring Cloud Bus</li>
</ul>

## In case you find a bug/suggested improvement for Spring Restfull Webservices
Our issue tracker is available here: https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/issues


## Working with Micro services in Eclipse

### prerequisites
The following items should be installed in your system:
* STS - Spring Tool Suite or Any development tool

### Steps:

1) Download or Clone this Project and do maven import.
```
git clone https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud.git
```
2) To Import the Praject Using Eclipse or STS
```
File -> Import -> Maven -> Existing Maven project
```

## Steps to test the application:
1) Install Erlang and RabbitMQ from the following link `https://www.rabbitmq.com/`
2) Once the download is done, run the rabbit mq which will run as background service in case for windows system.

3) Run the zipkin-server jar file using below command<br>
  For windows --> `set RABBIT_URI=amqp://localhost
                  java -jar zipkin-server-2.19.2-exec.jar`
  
4) Once the Erlang, RabbitMQ and zipkin software is up and running, follow the below steps to run the application in the below order
   a. netflix-eureka-naming-server
   b. netflix-zuul-api-gateway-server
   c. currency-exchange-service
   d. currency-conversion-service

5) In case to run the application with multiple instance for cross verifying the load balancing, One quick solution is:
    <br>Right click on the project -> Run as -> Run Configuration -> Select the instance and do duplicate -> Under arguments -> VM  Arguments -> Place the code as `-Dserver.port=8001` --> change the port whichever the port is convinient.

6) Follow the steps to run multiple instance of currency-exchange-service & currency-conversion-service. once the Application is successfully deployed, you can check the load balancing between multiple intance. <br> 
 `http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/500`

7) Here request will be sent from currency-conversion-service --> netflix-zuul-api-gateway-server --> currency-exchange-service

8) You can also check the Service registry from the url <br>
   `http://localhost:8761/`
   
9) To find the traces, you can refer to the url <br>
   `http://127.0.0.1:9411/zipkin/`


### For More Understanding

 
# Contributing

The [issue tracker](https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

