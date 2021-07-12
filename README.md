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