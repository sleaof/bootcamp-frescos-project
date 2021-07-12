INSERT INTO country_houses (id, country, name) VALUES ('1', 'Argentina', 'Casa central de Argentina');
INSERT INTO country_houses (id, country, name) VALUES ('2', 'Chile', 'Casa central de Chile');
INSERT INTO country_houses (id, country, name) VALUES ('3', 'Uruguay', 'Casa central de Uruguay');
INSERT INTO country_houses (id, country, name) VALUES ('4', 'Colombia', 'Casa central de Colombia');


INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('1', 'contra123', '1', 'user_one', '1');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('2', 'contra123', '1', 'user_two', '2');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('3', 'contra123', '3', 'user_three', '3');
INSERT INTO accounts (id, password, rol, username, id_country_house_fk) VALUES ('4', 'contra123', '4', 'user_four', '4');


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
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-15.0', '2021-07-07', '2021-05-21', '50', '50', '2021-10-07','3', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '60', '2021-10-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '150', '150', '2021-10-21','3','3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-15.0', '2021-07-07', '2021-05-21', '50', '50', '2021-10-07','3', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('0.0', '8.0', '2021-07-21', '2021-07-07', '40', '60', '2021-10-21','2', '3');
INSERT INTO batch (current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('-5.0', '-8.0', '2021-07-21', '2021-07-07', '150', '150', '2021-10-21','3','3');


INSERT INTO inbound_order ( order_date ) VALUES ( '2021-05-21');
INSERT INTO inbound_order ( order_date ) VALUES ( '2021-05-21');
INSERT INTO inbound_order ( order_date ) VALUES ( '2021-05-21');


INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '50', '1', '1');
INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '40', '2', '2');
INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '15', '3', '3');
INSERT INTO inbound_order_has_batch ( quantity, inbound_order_id_fk, batch_id_fk ) VALUES ( '15', '3', '2');


-- Insert Buyers
INSERT INTO buyers (name) VALUES ('Guilherme');
INSERT INTO buyers (name) VALUES ('Stephanie');
INSERT INTO buyers (name) VALUES ('Julia');


-- Insert purchase_orders
INSERT INTO purchase_orders ( date, order_status, buyer_id_fk) VALUES ( 20200202,'PROCESSING',1);
INSERT INTO purchase_orders ( date, order_status, buyer_id_fk) VALUES ( 20100202,'PROCESSING',2);
INSERT INTO purchase_orders ( date, order_status, buyer_id_fk) VALUES ( 20000202,'PROCESSING',3);


-- Insert batch_has_purchase_orders
INSERT INTO batch_has_purchase_orders (batch_id,purchase_order_id,quantity) VALUES (1,1,3);
INSERT INTO batch_has_purchase_orders (batch_id,purchase_order_id,quantity) VALUES (2,1,4);
INSERT INTO batch_has_purchase_orders (batch_id,purchase_order_id,quantity) VALUES (3,2,5);
INSERT INTO batch_has_purchase_orders (batch_id,purchase_order_id,quantity) VALUES (2,2,7);
INSERT INTO batch_has_purchase_orders (batch_id,purchase_order_id,quantity) VALUES (3,3,6);
INSERT INTO batch_has_purchase_orders (batch_id,purchase_order_id,quantity) VALUES (1,3,3);

CREATE OR REPLACE VIEW view_product_batch_in_warehouse AS
SELECT B.batch_id, B.current_quantity, B.product_id_fk, B.due_date, P.product_name, B.section_id_fk, S.warehouse_id_fk FROM batch AS B
INNER JOIN products AS P ON B.product_id_fk = P.product_id
INNER JOIN sections AS S ON B.section_id_fk = S.section_id;

