# purbasha-qms_java

##Running in local

### There are 2 ways to run the application in local machine. a) Native b) via Docker

#### Native
1) Clone the repo
2) Install mysql 5.7 and create a database named purbashaqms.
3) Run the application by running QmsApplication

#### Docker
1) Clone the repo
2) Run mvn clean package
3) To run the application run docker-compose -f docker-compose-local.yml up
4) To shut down the application run docker-compose -f docker-compose-local.yml down
   
###Swagger URL
http://localhost:8080/swagger-ui.html