# coworking_space Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/coworking_space-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)



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