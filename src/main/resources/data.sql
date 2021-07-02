INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('1', 'Argentina', 'Casa central de Argentina');
INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('2', 'Chile', 'Casa central de Chile');
INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('3', 'Uruguay', 'Casa central de Uruguay');
INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('4', 'Colombia', 'Casa central de Colombia');


INSERT INTO `accounts` (`id`, `password`, `rol`, `account_type`, `username`, `id_country_house_fk`) VALUES ('1', 'contra123', '1', 'SELLER', 'user_one', '1');
INSERT INTO `accounts` (`id`, `password`, `rol`, `account_type`, `username`, `id_country_house_fk`) VALUES ('2', 'contra123', '1', 'BAYER', 'user_two', '2');
INSERT INTO `accounts` (`id`, `password`, `rol`, `account_type`, `username`, `id_country_house_fk`) VALUES ('3', 'contra123', '1', 'MANAGER', 'user_three', '3');
INSERT INTO `accounts` (`id`, `password`, `rol`, `account_type`, `username`, `id_country_house_fk`) VALUES ('4', 'contra123', '1', 'BAYER', 'user_four', '4');


--Insert produtos de uma determinada categoria
INSERT INTO products (product_id, product_name, product_category, temperature, validated) VALUES ('1','Carne', 'FROZEN', 0.0, '2021-05-21');
INSERT INTO products (product_id, product_name, product_category, temperature, validated) VALUES ('2','Peixe', 'FRESH', 0.0, '2021-05-21');
INSERT INTO products (product_id, product_name, product_category, temperature, validated) VALUES ('3','Maca', 'REFRIGERATED', 0.0, '2021-05-21');


--Insert a sections de um WareHouse
INSERT INTO sections (section_id, section_name_category, min_temperature, max_temperature, current_temperature) VALUES ('1', 'FROZEN', -15.0, 0.0, -6.0);
INSERT INTO sections (section_id, section_name_category, min_temperature, max_temperature, current_temperature) VALUES ('2', 'FRESH', 10.1, 20.0, 14.0);
INSERT INTO sections (section_id, section_name_category, min_temperature, max_temperature, current_temperature) VALUES ('3', 'REFRIGERATED', 0.1, 10.0, 2.0);


--Insert lotes de um determinado produto
INSERT INTO batch (batch_id, current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('1', '-5.0', '-8.0', '2021-05-21', '2021-05-21', '50', '50', '2021-05-21','1', '1');
INSERT INTO batch (batch_id, current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('2', '0.0', '8.0', '2021-03-21', '2021-03-21', '40', '60', '2021-05-21','2', '2');
INSERT INTO batch (batch_id, current_temperature, min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk, section_id_fk) VALUES ('3', '-5.0', '-8.0', '2021-05-21', '2021-05-21', '15', '25', '2021-05-21','3','3');


----Insert enderecos de uma warehouse
INSERT INTO addresses (address_id, address_name, city, state, street) VALUES ('1', 'fullfilment Cajamar', 'Cajamar', 'SP', 'Avenida Doutor Antonio Joao Abdalla, Nº 1111');
INSERT INTO addresses (address_id, address_name, city, state, street) VALUES ('2', 'fullfilment Extrema', 'Extrema', 'MG', 'Avenida Matias de Camargo,  Nº 2222');
INSERT INTO addresses (address_id, address_name, city, state, street) VALUES ('3', 'fullfilment Guarulhos', 'Guarulhos', 'SP', 'Rua das Flores,  Nº 3333');


----Insert supervisores em uma warehouse
INSERT INTO supervisors (supervisor_id, supervisor_name) VALUES ('1', 'Sergio');
INSERT INTO supervisors (supervisor_id, supervisor_name) VALUES ('2', 'Lorivaldo');
INSERT INTO supervisors (supervisor_id, supervisor_name) VALUES ('3', 'Garibalda');


----Insert uma warehouse
INSERT INTO warehouses (warehouse_id, warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('1', 'Cajamar', '1', '1');
INSERT INTO warehouses (warehouse_id, warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('2', 'Extrema', '2', '2');
INSERT INTO warehouses (warehouse_id, warehouse_name, address_address_id, supervisor_supervisor_id) VALUES ('3', 'Guarulhos', '3', '3');