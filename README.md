# Microservices-with-Spring-Cloud
Microservices with Spring Boot and Spring Cloud

## What is Microservices?	
<ul><li>Micro services is a small autonomous services that work together.</li>
<li>It can also be defined as a bare minimum of centralized management of these services, which may be written in different programming language and use different data storage technologies.</li>
</ul>  

### Topics Covered
<ul>
  <li>Spring cloud config server & Bus</li>
  <li>Load Balancing with Ribbon & Feign</li>
  <li>Implementing Naming server with Eureka</li>
  <li>Implementing API gateway with Zuul</li>
  <li>Distributed Tracing with Zipkin</li>
  <li>Fault Tolerance with Hystrix</li>
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
    <br>Right click on the project -> Run as -> Run Configuration -> Select the instance and do duplicate -> Under arguments -> VM  Arguments -> Place the code as `-Dserver.port=8001` --> change the port whichever the port is convinient. <br>
  <img src="https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/blob/master/docs/Pic1.png" width="600px;"/>

6) Follow the steps to run multiple instance of currency-exchange-service & currency-conversion-service. once the Application is successfully deployed, you can check the load balancing between multiple intance. <br> 
 `http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/500` <br>
  <img src="https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/blob/master/docs/Pic4.png" width="600px;"/>

7) Here request will be sent from currency-conversion-service --> netflix-zuul-api-gateway-server --> currency-exchange-service

8) You can also check the Service registry from the url <br>
   `http://localhost:8761/` <br>
   <img src="https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/blob/master/docs/Pic3.png" width="600px;"/>
   
9) To find the traces, you can refer to the url <br>
   `http://127.0.0.1:9411/zipkin/` <br>
    <img src="https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/blob/master/docs/Pic2.png" width="600px;"/>
    
10) The overall attempt was to build microservices architecture using rest services and load balancing & also tracing of each request.
  <img src="https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/blob/master/docs/2020-05-22_19h43_24.gif" width="600px;"/>


### For More Understanding
Challenges with Micro services:

1.	Bounded context.
Difficulty in designing boundary for multiple micro services module.
2.	Configuration Management:
If we have 10 micro services running in 5 environments and for each environment will be having multiple instance running, since as the number of services increases it will be difficulty for maintaining the configuration.
3.	Dynamic Scale Up & Scale Down:
Loads on different MS will be different at different instance of time. At particular time we may need more instance during busy/peak hours and other time we might not need all the services.
4.	Visibility:
We have multiple MS running and we got bug in any of the MS, So for identifying the issue in which MS is causing, we need a greater visibility of each MS.
5.	Pack of Cards:
If MS architecture is not well designed means it will be like pack of cards, Since one MS will be calling another & so on. And there might be certain MS which would be fundamental for the whole thing, and that MS goes down means the entire application might go down.

## Spring Cloud
Spring Cloud provides tools for developers to quickly build some of the common patters in distributed system, for ex:  configuration management, control bus, leadership election, one time tokens, intelligent routing, circuit breakers, service discovery etc

### Features
1.	Distributed configuration
2.	Routing
3.	Service registration & discovery
4.	Load balancing
5.	Circuit Breakers
6.	Global locks
7.	Leadership Election & Cluster state
8.	Distributed Messaging
9.	Service to service calls

 ### Solutions provided by Spring Cloud

Solutions provided by Spring Cloud for challenges faced in Micro services:

1.	Configuration management:
Spring Cloud Config Server provides an approach for storing the configuration in git repository.	
2.	Dynamic Scale Up & Scale Down:
In MS maintaining load balancing is bigger task, And It can be achieved by using spring cloud, by adding or removing server dynamically with
•	Naming Server (Eureka) – Here all the instance of MS would register with naming server, The imp feature is of Naming server is:  a) Service Registration,  b) Service Discovery, 
This helps in Dynamic relationship b/w the Services.
•	Ribbon (Client Side Load balancing) - It make sure load is evenly distributed among the existing services which would get register with it. 
•	Feign (Easier Rest Clients) – Mechanism to write simple restful cleints.
3.	Visibility and Monitoring : The solutions for Visibility and Monitoring is 
•	Zipkin Distributed Tracing Server: 
We would use Spring Cloud South to assign ID to a request across multiple components. We would use Zipkin Distributed Tracing server  to trace request across multiple component. 
•	Netflix API Gateway –  It provide features like Logging, Security, Analytics etc, We don’t want to implement all these common features in every MS, API GateWay provide great solution for this kind of solutions, We use  Netflix Zool API Gateway for implementing those common features.

4.	Fault Tolerance 
Hystrix – If service is down, Hystrix helps us to configure default response.

### Advantages of Microservices:

•	New technology and process adoption:
It enables us to adopt new technology and process very easily.

•	Dynamic Scaling:
It helps us to scale up and scale down the application dynamically.

•	Faster Release cycle: 
Since we are developing smaller component micro services, it’s easier to release the micro services.

 
# Contributing

The [issue tracker](https://github.com/Sudarshan-Gowda/Microservices-with-Spring-Cloud/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

