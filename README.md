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

#### Answers to questions
Is it possible to have code coverage of more than 90% without covering all test cases? How? Why?
It would take a great expense, and we would have to develop code in such a way, so it is testable, which leads to a lot of refactoring while you are adding new code.
One can test a piece of code through another piece, so that is one way to achieve higher % of covering.

Pros and cons of mocking objects in tests?
* When we are doing isolated tests (unit tests) we don't want a whole service running, so we mock objects to imitate that behaviour. That is exactly what i did when i was testing endpoints where i mocked CarService. This is a big PRO of mocking.
* A big con is that it can provide false confidence, since we are only doing unit testing and not integration testing. So we can come up with a scenario where unit works, but not in integration.

Mockito vs PowerMock vs EasyMock?
* Mockito is a framework that helps with test case writing, powermock is an extension that allows mocking of specific methods, classes etc. Comparing EasyMock with Mockito, there are some differences like, EasyMock doesnt have spies and EasyMock is open source.

## Authors

Contributors names and contact info

* Dalibor Veselinovic
