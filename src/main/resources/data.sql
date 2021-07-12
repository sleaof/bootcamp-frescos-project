INSERT INTO country_houses (id, country, name) VALUES ('1', 'Argentina', 'Casa central de Argentina');
INSERT INTO country_houses (id, country, name) VALUES ('2', 'Chile', 'Casa central de Chile');
INSERT INTO country_houses (id, country, name) VALUES ('3', 'Uruguay', 'Casa central de Uruguay');
INSERT INTO country_houses (id, country, name) VALUES ('4', 'Colombia', 'Casa central de Colombia');


INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('1', 'contra123', '1', 'BUYER', '1');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('2', 'contra123', '1', 'SELLER', '2');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('3', 'contra123', '2', 'SUPERVISOR_1', '3');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('4', 'contra123', '2', 'SUPERVISOR_2', '4');


--Insert produtos de uma determinada categoria
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Carne', 'FROZEN', 0.0, '2021-05-21',35.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Massa-Congelada', 'FROZEN', 0.0, '2021-06-21',25.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Picolé de Abacate', 'FROZEN', 0.0, '2021-07-07',4.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Peixe', 'FRESH', 5.0, '2021-06-21',30.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Maca-Verde', 'FRESH', 20.0, '2021-05-21',2.5);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Laranja', 'FRESH', 20.0, '2021-05-21',3.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Margarina', 'REFRIGERATED', 4.0, '2021-06-21',4.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Queijo-Fresco', 'REFRIGERATED', 3.0, '2021-05-21',16.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Iogurte', 'REFRIGERATED', 8.0, '2021-05-21',8.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Margarina', 'REFRIGERATED', 4.0, '2021-08-30',4.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('leite', 'REFRIGERATED', 4.0, '2021-08-29',4.0);


INSERT INTO addresses (address_name, city, state, street) VALUES ('fullfilment Cajamar', 'Cajamar', 'SP', 'Avenida Doutor Antonio Joao Abdalla, Nº 1111');
INSERT INTO addresses (address_name, city, state, street) VALUES ('fullfilment Extrema', 'Extrema', 'MG', 'Avenida Matias de Camargo,  Nº 2222');
INSERT INTO addresses (address_name, city, state, street) VALUES ('fullfilment Guarulhos', 'Guarulhos', 'SP', 'Rua das Flores,  Nº 3333');


-- Insert supervisores em uma warehouse
INSERT INTO supervisors (supervisor_name) VALUES ('Sergio');
INSERT INTO supervisors (supervisor_name) VALUES ('Lorivaldo');
INSERT INTO supervisors (supervisor_name) VALUES ('Garibalda');


-- Insert uma warehouse
INSERT INTO warehouses (warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('Cajamar', '1', '1');
INSERT INTO warehouses (warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('Extrema', '2', '2');
INSERT INTO warehouses (warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('Guarulhos', '3', '3');


--Insert a sections de um WareHouse
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -15.0, 0.0, -6.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -16.0, 0.0, -6.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FRESH', 10.1, 20.0, 14.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('REFRIGERATED', 0.1, 10.0, 2.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -15.0, 0.0, -6.0, '2');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FRESH', 10.1, 20.0, 14.0, '2');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('REFRIGERATED', 0.1, 10.0, 2.0, '2');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -15.0, 0.0, -6.0, '3');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FRESH', 10.1, 20.0, 14.0, '3');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('REFRIGERATED', 0.1, 10.0, 2.0, '3');


-- Insert lotes de um determinado produto
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '10', '2021-10-21','1', '1');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '10', '2021-10-21','1', '2');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '25', '2021-8-21','1', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '50', '2021-6-21','1', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '60', '2021-6-21','1', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '30', '2021-5-21','1', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '10', '2021-10-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '25', '2021-8-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '50', '2021-6-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '60', '2021-6-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '30', '2021-5-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '150', '150', '2021-10-21','3','3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-15.0', '2021-07-07', '2021-05-21', '50', '50', '2021-10-07','3', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '130', '130', '2021-12-21','3','3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-06-07', '120', '150', '2021-10-21','3','3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '150', '200', '2021-8-21','3','3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '150', '200', '2021-8-21','3','3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('6.0', '0.0', '2021-07-07', '2021-05-21', '20', '20', '2022-08-07','10', '2');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('6.0', '0.0', '2021-07-07', '2021-05-21', '20', '20', '2022-08-07','11', '2');


INSERT INTO inbound_order ( order_date ) VALUES ( '2021-05-21');
INSERT INTO inbound_order ( order_date ) VALUES ( '2021-05-21');
INSERT INTO inbound_order ( order_date ) VALUES ( '2021-05-21');


INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '50', '1', '1');
INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '40', '2', '2');
INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '15', '3', '3');
INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '15', '3', '2');


-- Insert de compradores
INSERT INTO buyers (name) VALUES ('Joana Fernandes');
INSERT INTO buyers (name) VALUES ('Pedro Borges');
INSERT INTO buyers (name) VALUES ('Clara Maria de Freitas');
INSERT INTO buyers (name) VALUES ('Amarildo Alves');
INSERT INTO buyers (name) VALUES ('Wesley Mendes');


-- Insert de ordens de compras
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-07-07', 'PROCESSING', 1);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-07-06', 'PROCESSING', 2);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-07-06', 'PROCESSING', 2);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-07-02', 'PREPARING', 5);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-07-02', 'PREPARING', 3);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-06-30', 'DELIVERING', 4);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-06-29', 'DELIVERING', 4);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-06-29', 'DELIVERING', 1);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-06-25', 'DELIVERING', 5);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-06-15', 'DELIVERING', 3);
INSERT INTO purchase_orders (date, order_status, buyer_id_fk) VALUES ('2021-06-15', 'DELIVERING', 2);


-- Insert da relação (N-N) de lotes e ordens de compra
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (2, 14, 1);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (1, 8, 2);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (1, 8, 2);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (4, 2, 5);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (6, 12, 3);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (1, 13, 4);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (6, 10, 4);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (2, 1, 1);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (2, 13, 5);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (1, 4, 3);
INSERT INTO batch_has_purchase_orders (quantity, batch_id_fk, purchase_order_id_fk) VALUES (1, 8, 2);


-- Create Views
CREATE OR REPLACE VIEW view_product_batch_in_warehouse AS
SELECT B.batch_id AS batchNumber, B.product_id_fk AS productId, P.product_category AS productType, B.current_quantity AS quantity, B.due_date AS dueDate
FROM batch AS B
INNER JOIN products AS P ON B.product_id_fk = P.product_id
INNER JOIN sections AS S ON B.section_id_fk = S.section_id;


CREATE OR REPLACE VIEW view_products_from_order_by_id AS
SELECT PO.purchase_order_id, P.product_id AS productId, P.product_name AS productName, BP.quantity AS quantity
FROM products AS P
INNER JOIN batch AS B ON p.product_id = B.product_id_fk
INNER JOIN batch_has_purchase_orders AS BP ON B.batch_id = BP.batch_id_fk
INNER JOIN purchase_orders AS PO ON BP.purchase_order_id_fk = PO.purchase_order_id;


CREATE OR REPLACE VIEW view_most_selling_products AS
SELECT w.warehouse_name, p.product_name, SUM(bp.quantity) as quantity
FROM products as p
INNER JOIN batch as b ON p.product_id = b.product_id_fk
INNER JOIN batch_has_purchase_orders as bp ON  b.batch_id = bp.batch_id_fk
INNER JOIN purchase_orders as po ON bp.purchase_order_id_fk = po.purchase_order_id
INNER JOIN sections as s ON b.section_id_fk = s.section_id
INNER JOIN warehouses as w ON s.warehouse_id_fk = w.warehouse_id
GROUP BY w.warehouse_name, product_name
ORDER BY quantity DESC LIMIT 3;


CREATE OR REPLACE VIEW view_check_product_batch_in_warehouse AS
SELECT B.batch_id, B.current_quantity, B.product_id_fk, B.due_date, P.product_name, B.section_id_fk, S.warehouse_id_fk FROM batch AS B
INNER JOIN products AS P ON B.product_id_fk = P.product_id
INNER JOIN sections AS S ON B.section_id_fk = S.section_id;

CREATE OR REPLACE VIEW view_product_batch_in_warehouse AS
SELECT B.batch_id AS batchNumber, B.product_id_fk AS productId, P.product_category AS productType, B.current_quantity AS quantity, B.due_date AS dueDate
FROM batch AS B
INNER JOIN products AS P ON B.product_id_fk = P.product_id
INNER JOIN sections AS S ON B.section_id_fk = S.section_id;

CREATE OR REPLACE VIEW view_warehouse_product_total_quantity AS
select p.product_id, w.warehouse_id, b.current_quantity from batch as b
inner join sections as s on b.section_id_fk = s.section_id
inner join warehouses as w on s.warehouse_id_fk = w.warehouse_id
inner join products as p on b.product_id_fk = p.product_id;