# coworking_space Project

The Application is supposed to be a simple backend for a coworking space and provide simple functionalities for diffrent tasks using REST.

## Repository URL
https://github.com/Laureatus/UeK-223_22-3216_LFa

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw quarkus:dev
```

## Swagger

This project uses Swagger. It can be accessed at:
http://localhost:8080/q/swagger-ui/

## Postgres

Postgres can be accessed at:
https://localhost:5050


## Testdata

The Testing Data is defined inside the resource folder in the file import.sql.

The Table structure is the following:
<p><br>

### Table: applicationuser

id | email | firstname | isAdmin | lastname | password |
--- | --- | --- | --- |--- |--- |
1 | test@gmail.com | lorin | true | fankhauser | password123
2 | test2@gmail.com | Max | false | Mustermann | max123

### Table booking
id | bookeddate | halfday | wholeday | user_id |
--- | --- | --- | --- | --- |
1 | 2019-01-21T05:47:08.644 | true | false | 1 |
2 | 2019-01-21T05:47:08.644 | false | true | 2 |

### Table coffee

id | time | user_id |
--- | --- | --- |
1 | 2019-01-21T05:47:08.644 | 1 |

### Table lunch 

id | name | supplier | user_id |
--- | --- | --- | --- |
1 | pizza | PizzaHut | 1 |

### Table material 

id | name | user_id |
--- | --- | --- |
1 | usb type C charger_1 | 1 |

