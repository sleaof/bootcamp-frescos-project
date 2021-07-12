# dambetan01

# Spring Boot App model for Java 11

We provide a basic model for JDK 11 / Spring based web applications.

Please address any questions and comments to [Fury Issue Tracker](https://github.com/mercadolibre/fury/issues).

## Usage

### Excutando Endpoints (Request necessários) no Postman
Deve ser gerado o Token

#### ENDPOINTS permitidos ao SELLER/BUYER
  Autentique-se como BUYER/SELLER Exemplo: http://localhost:8082/api/v1/sign-in?username=BUYER&password=contra123

#### GET http://localhost:8082/api/v1/fresh-products/

#### GET http://localhost:8082/api/v1/fresh-products/list
    @Params
    category = fresh

#### GET http://localhost:8082/fresh-products/orders/
    @Params
    orderId = 1

#### POST http://localhost:8082/fresh-products/orders/
    {
    "date": "2021-05-26",
    "buyer": 2,
    "orderStatus": "PROCESSING",
    "products":
    [
    {
    "productId": 10,
    "quantity": 15
    },
    {
    "productId": 11,
    "quantity": 18
    }
    ]
    }
#### PUT http://localhost:8082/fresh-products/orders
    @Params
    orderId = 12

    {
    "date": "2021-05-26",
    "buyer": 2,
    "orderStatus": "PROCESSING",
    "products":
    [
    {
    "productId": 10,
    "quantity": 10
    },
    {
    "productId": 11,
    "quantity": 5
    }
    ]
    }
- ENDPOINTS permitidos ao REPRESENTANTE
  Autentique-se como representante

#### Exemplo: http://localhost:8082/api/v1/sign-in?username=SUPERVISOR_1&password=contra123

#### POST http://localhost:8082/api/v1/fresh-products/inbounded/
    {
    "orderDate": "2021-07-02",
    "section":{
    "sectionCode" : 1,
    "warehouseCode" : 1
    },
    "batchStock" : [
    {
    "productId": 2,
    "currentTemperature": 12.0,
    "minTemperature" : 7.0,
    "initialQuantity": 100,
    "currentQuantity": 50,
    "manufacturingDate": "2021-07-02",
    "manufacturingTime": "2021-07-02",
    "dueDate": "2021-07-02"
    },
    {
    "productId": 3,
    "currentTemperature": 5.0,
    "minTemperature" : 5.0,
    "initialQuantity": 30,
    "currentQuantity": 35,
    "manufacturingDate": "2021-07-02",
    "manufacturingTime": "2021-07-02",
    "dueDate": "2021-07-02"
    }
    ]
    }
#### PUT http://localhost:8082/api/v1/fresh-products/inbounded/
    {
    "orderDate": "2021-07-02",
    "section":{
    "sectionCode" : 1,
    "warehouseCode" : 1
    },
    "batchStock" : [
    {
    "batchNumber" : 9,
    "productId": 2,
    "currentTemperature": 1,
    "minTemperature" : 7.0,
    "initialQuantity": 50,
    "currentQuantity": 50,
    "manufacturingDate": "2021-07-02",
    "manufacturingTime": "2021-07-02",
    "dueDate": "2021-07-02"
    },
    {
    "batchNumber" : 2,
    "productId": 3,
    "currentTemperature": 6.0,
    "minTemperature" : 4.0,
    "initialQuantity": 30,
    "currentQuantity": 32,
    "manufacturingDate": "2021-07-02",
    "manufacturingTime": "2021-07-02",
    "dueDate": "2021-07-03"
    }
    ]
    }
#### GET, http://localhost:8082/fresh-products/list/warehouse //Ordenar por quantidade @Params productId = 1 orderType = c warehouseId = 1
    //Ordernar pela data
    @Params
    productId = 1
    orderType = f
    warehouseId = 1
#### GET, http://localhost:8082/fresh-products/warehouse/ 
    @Params productId = 1

#### GET http://localhost:8082/fresh-products/due-date/ 
    @Params days = 10

#### GET http://localhost:8082/fresh-products/due-date/list/ 
    @Params days = 10 category = frozen

#### GET http://gabriel_borba_paim/inboud-order/betweendate
    @Params
    firsDate = 2021-05-21
    secondDate = 2021-06-21


### SCOPE

The suffix of each Fury **SCOPE** is used to know which properties file to use, it is identified from the last '-' of the name of the scope.

If you want to run the application from your development IDE, you need to configure the environment variable **SCOPE=local** in the app luncher.

The properties of **application.yml** are always loaded and at the same time they are complemented with **application-<SCOPE_SUFFIX>.yml** properties. If a property is in both files, the one that is configured in **application-<SCOPE_SUFFIX>.yml** has preference over the property of **application.yml**.

For example, for the **SCOPE** 'items-loader-test' the **SCOPE_SUFFIX** would be 'test' and the loaded property files will be **application.yml** and **application-test.yml**

### Web Server

Each Spring Boot web application includes an embedded web server. For servlet stack applications, Its supports three web Servers:
  * Tomcat (maven dependency: `spring-boot-starter-tomcat`)
  * Jetty (maven dependency: `spring-boot-starter-jetty`)
  * Undertow (maven dependency: `spring-boot-starter-undertow`)

This project is configured with Jetty, but to exchange WebServer, it is enough to configure the dependencies mentioned above in the pom.xml file.

### Main

The main class for this app is Application, where Spring context is initialized and SCOPE_SUFFIX is generated.

### Error Handling

We also provide basic handling for exceptions in ControllerExceptionHandler class.

## Api Documentation

This project uses Springfox to automate the generation of machine and human readable specifications for JSON APIs written using Spring. Springfox works by examining an application, once, at runtime to infer API semantics based on spring configurations, class structure and various compile time java Annotations.

You can change this configuration in SpringfoxConfig class.

## [Release Process](https://release-process.furycloud.io/#/)

### Usage

1. Specify the correct tag for your app in your `Dockerfile` and `Dockerfile.runtime`, according to the desired Java runtime version.

```
# Dockerfile
FROM hub.furycloud.io/mercadolibre/java:1.11-mini
```

You can find all available tags for your `Dockerfile` [here](https://github.com/mercadolibre/fury_java-mini#supported-tags)

```
# Dockerfile.runtime
FROM hub.furycloud.io/mercadolibre/java:1.11-runtime-mini
```

You can find all available tags for your `Dockerfile.runtime` [here](https://github.com/mercadolibre/fury_java-mini-runtime#supported-tags)

2. Start coding!

### Questions

[Release Process Issue Tracker](https://github.com/mercadolibre/fury_release-process/issues)
