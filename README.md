# RT Programs

## Development Tool
1. Java 17
2. Spring-Boot 3.4.x
3. Maven 3.9.x

## Modules
1. common
2. email-notification-service
3. product-service



## Spring Profiles
1. dev
2. prod


All the profiles packages to `jar` 

## Build
To build all the projects/modules

mvn clean install -am -DskipTests -P (dev|prod)

`mvn clean install -am -DskipTests -P dev`
to `jar`


### To build a single module or project

`mvn clean install -pl email-notification-service -am -DskipTests -P dev`

The cli command above with build `email-notification-service` and all it's dependencies and package the solution to `jar`
