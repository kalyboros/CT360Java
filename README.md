# CT360 Java assignment 

First weeks task on basic Java tutoring module

#### Second task
Created test cases for car API service, it covers all the endpoints.
Since we are unit testing, we will have to mock the service class, because we are unit testing endpoints and their returns statements and not database enquiries (that would be integration testing).

Check class CarControllerTest. It covers everything, except CarRepository and CarServiceImpl (80% coverage).


#### Third task

Created a new web service for managing cars.
It consists of an API that receives different requests.
* http://localhost:8080/api/cars/create that receives a post request with json object and creates a new car
* http://localhost:8080/api/cars/delete/{id} that receives a delete request with id as param and then deletes a car with that id in database
* http://localhost:8080/api/cars/get to return all cars from sql db
* http://localhost:8080/api/cars/updateCar/{id} that receives put requst with json body and updates a car in db with that id with json received data

#### Database
Database configuration.
* database name: cars
* table 1: car: columns: int id, varchar(45) brand, varchar(45) model, int kilometers
* table 2: supercar (unused, doesnt matter)

dont forget to add dependencies to pom and set user for mysql in application.properties




## Authors

Contributors names and contact info

* Dalibor Veselinovic
