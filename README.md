# Bootcamp 

### Requisitos 01: Insira o lote no armazém de distruibuição

Token - Representante

POST - localhost:8082/api/v1/fresh-products/inbounded/

```JSON
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
```

PUT - localhost:8082/api/v1/fresh-products/inbounded/

```JSON
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
```

### Requisitos 02: Adicionar produto ao carrinho de compras

Token - Comprador

GET - http://localhost:8082/api/v1/fresh-products/

Exemplo de Response - Lista Produtos

```JSON
[
    {
        "productName": "Carne",
        "validated": "2021-05-21",
        "price": 35.0,
        "productCategory": "FROZEN"
    },
    {
        "productName": "Laranja",
        "validated": "2021-05-21",
        "price": 3.0,
        "productCategory": "FRESH"
    },
    {
        "productName": "Margarina",
        "validated": "2021-08-30",
        "price": 4.0,
        "productCategory": "REFRIGERATED"
    },
]
```

GET - http://localhost:8082/api/v1/fresh-products/list?category=fresh

Lista produtos por categoria.

    @Params
    category = fresh

GET - http://localhost:8082/api/v1/fresh-products/orders/?orderId=1

Lista de produtos que compõem o PurchaseOrder.

    @Params
    orderId = 1

PUT - http://localhost:8082/api/v1/fresh-products/orders?orderId=12

```JSON
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
```


### Requisitos 03: Verifique a localização de um produto no armazém

Token - Representante

GET - http://localhost:8082/api/v1/fresh-products/list/warehouse?productId=1&orderType=f&warehouseId=1

Ordena batch por data de vencimento

    @Params
    productId = 1
    orderType = f
    warehouseId = 1
    
GET - http://localhost:8082/api/v1/fresh-products/list/warehouse?productId=1&orderType=c&warehouseId=1

Ordena batch por quantidade atual do produto.

    @Params
    productId = 1
    orderType = c
    warehouseId = 1
    
### Requisitos 04: Verificar o estoque de um produto em todos os armazéns

Token - Representante

GET - http://localhost:8082/api/v1/fresh-products/warehouse/?productId=1

    @Params
    productId = 1

### Requisitos 05: Verifique a data de validade por lote

Token - Representante

GET - http://localhost:8082/api/v1/fresh-products/due-date/list/?days=10&category=frozen

    @Params 
    days = 10 
    category = frozen
    
GET - http://localhost:8082/api/v1/fresh-products/due-date/?days=10

    @Params 
    days = 10


### Requisitos 06: Ordenar produtos por menor e maior preço

Token - Comprador

GET - http://localhost:8082/api/v1/fresh-products/list/price?orderType=A

Ordena lista de produtos por menor preço

    @Params
    orderType = A
    
GET - http://localhost:8082/api/v1/fresh-products/list/price?orderType=D

Ordena lista de produtos por maior preço

    @Params
    orderType = D 

