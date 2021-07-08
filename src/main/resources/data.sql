INSERT INTO country_houses (id, country, name) VALUES ('1', 'Argentina', 'Casa central de Argentina');
INSERT INTO country_houses (id, country, name) VALUES ('2', 'Chile', 'Casa central de Chile');
INSERT INTO country_houses (id, country, name) VALUES ('3', 'Uruguay', 'Casa central de Uruguay');
INSERT INTO country_houses (id, country, name) VALUES ('4', 'Colombia', 'Casa central de Colombia');


INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('1', 'contra123', '1', 'user_one', '1');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('2', 'contra123', '1', 'user_two', '2');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('3', 'contra123', '1', 'user_three', '3');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('4', 'contra123', '1', 'user_four', '4');


--Insert produtos de uma determinada categoria
INSERT INTO products (product_id, product_name, product_category, temperature, validated, price) VALUES ('1','Carne', 'FROZEN', 0.0, '2021-05-21',20.0);
INSERT INTO products (product_id, product_name, product_category, temperature, validated, price) VALUES ('2','Peixe', 'FRESH', 0.0, '2021-05-21',40.0);
INSERT INTO products (product_id, product_name, product_category, temperature, validated, price) VALUES ('3','Maca', 'REFRIGERATED', 0.0, '2021-05-21',60.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Margarina', 'REFRIGERATED', 4.0, '2021-06-21',4.0);


INSERT INTO addresses (address_id, address_name, city, state, street) VALUES ('1', 'fullfilment Cajamar', 'Cajamar', 'SP', 'Avenida Doutor Antonio Joao Abdalla, Nº 1111');
INSERT INTO addresses (address_id, address_name, city, state, street) VALUES ('2', 'fullfilment Extrema', 'Extrema', 'MG', 'Avenida Matias de Camargo,  Nº 2222');
INSERT INTO addresses (address_id, address_name, city, state, street) VALUES ('3', 'fullfilment Guarulhos', 'Guarulhos', 'SP', 'Rua das Flores,  Nº 3333');

-- Insert supervisores em uma warehouse
INSERT INTO supervisors (supervisor_name) VALUES ('Sergio');
INSERT INTO supervisors (supervisor_name) VALUES ('Lorivaldo');
INSERT INTO supervisors (supervisor_name) VALUES ('Garibalda');


-- Insert Addresses
INSERT INTO addresses (address_name, city, state, street) VALUES ('fullfilment Cajamar', 'Cajamar', 'SP', 'Avenida Doutor Antonio Joao Abdalla, Nº 1111');
INSERT INTO addresses (address_name, city, state, street) VALUES ('fullfilment Extrema', 'Extrema', 'MG', 'Avenida Matias de Camargo,  Nº 2222');
INSERT INTO addresses (address_name, city, state, street) VALUES ('fullfilment Guarulhos', 'Guarulhos', 'SP', 'Rua das Flores,  Nº 3333');


-- Insert Warehouses
INSERT INTO warehouses (warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('Cajamar', '1', '1');
INSERT INTO warehouses (warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('Extrema', '2', '2');
INSERT INTO warehouses (warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('Guarulhos', '3', '3');


-- Insert a sections de um WareHouse
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -15.0, 0.0, -6.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FRESH', 10.1, 20.0, 14.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('REFRIGERATED', 0.1, 10.0, 2.0, '1');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -15.0, 0.0, -6.0, '2');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FRESH', 10.1, 20.0, 14.0, '2');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('REFRIGERATED', 0.1, 10.0, 2.0, '2');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FROZEN', -15.0, 0.0, -6.0, '3');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('FRESH', 10.1, 20.0, 14.0, '3');
INSERT INTO sections (section_name_category, min_temperature, max_temperature, current_temperature, warehouse_id_fk) VALUES ('REFRIGERATED', 0.1, 10.0, 2.0, '3');


-- Insert products
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Carne', 'FROZEN', 0.0, '2021-05-21',35.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Massa-Congelada', 'FROZEN', 0.0, '2021-06-21',25.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Picolé de Abacate', 'FROZEN', 0.0, '2021-07-07',4.0);


INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Peixe', 'FRESH', 5.0, '2021-06-21',30.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Maca-Verde', 'FRESH', 20.0, '2021-05-21',2.5);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Laranja', 'FRESH', 20.0, '2021-05-21',3.0);


INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Margarina', 'REFRIGERATED', 4.0, '2021-06-21',4.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Queijo-Fresco', 'REFRIGERATED', 3.0, '2021-05-21',16.0);
INSERT INTO products (product_name, product_category, temperature, validated, price) VALUES ('Iogurte', 'REFRIGERATED', 8.0, '2021-05-21',8.0);


-- Insert lotes de um determinado produto
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-15.0', '2021-07-07', '2021-07-21', '150', '150', '2021-10-07','3', '1');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-06-07', '40', '60', '2021-06-21','2', '1');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '20', '20', '2021-10-21','3','1');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('18.0', '15.0', '2021-07-07', '2021-05-21', '200', '200', '2021-07-19','5', '2');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('18.0', '15.0', '2021-07-07', '2021-05-21', '150', '150', '2021-08-07','4', '2');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('6.0', '0.0', '2021-07-07', '2021-05-21', '20', '20', '2022-08-07','6', '2');


INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-15.0', '2021-07-07', '2021-07-21', '150', '150', '2021-10-07','3', '4');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-06-07', '40', '60', '2021-06-21','2', '4');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '20', '20', '2021-06-21','3','4');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('18.0', '15.0', '2021-07-07', '2021-05-21', '200', '200', '2021-07-19','5', '5');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('18.0', '15.0', '2021-07-07', '2021-05-21', '150', '150', '2021-06-07','4', '5');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('6.0', '0.0', '2021-07-07', '2021-05-21', '20', '20', '2022-08-07','6', '5');


INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('05.0', '08.0', '2021-07-07', '2021-05-21', '500', '5500', '2021-07-19','4', '6');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('04.0', '07.0', '2021-07-07', '2021-05-21', '150', '130', '2021-06-07','7', '6');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('03.0', '08.0', '2021-07-07', '2021-05-21', '220', '220', '2022-08-07','8', '6');


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
SELECT B.batch_id, B.product_id_fk, P.product_category, B.due_date, B.section_id_fk, S.warehouse_id_fk, B.current_quantity FROM batch AS B
INNER JOIN products AS P ON B.product_id_fk = P.product_id
INNER JOIN sections AS S ON B.section_id_fk = S.section_id;


CREATE OR REPLACE VIEW view_products_from_order_by_id AS
SELECT PO.purchase_order_id, P.product_id AS productId, P.product_name AS productName, BP.quantity AS quantity
FROM products AS P
INNER JOIN batch AS B ON p.product_id = B.product_id_fk
INNER JOIN batch_has_purchase_orders AS BP ON B.batch_id = BP.batch_id_fk
INNER JOIN purchase_orders AS PO ON BP.purchase_order_id_fk = PO.purchase_order_id;


