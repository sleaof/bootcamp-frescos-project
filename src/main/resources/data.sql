INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('1', 'Argentina', 'Casa central de Argentina');
INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('2', 'Chile', 'Casa central de Chile');
INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('3', 'Uruguay', 'Casa central de Uruguay');
INSERT INTO `country_houses` (`id`, `country`, `name`) VALUES ('4', 'Colombia', 'Casa central de Colombia');


INSERT INTO `accounts` (`id`, `password`, `rol`, `username`, `id_country_house_fk`) VALUES ('1', 'contra123', '1', 'user_one', '1');
INSERT INTO `accounts` (`id`, `password`, `rol`, `username`, `id_country_house_fk`) VALUES ('2', 'contra123', '1', 'user_two', '2');
INSERT INTO `accounts` (`id`, `password`, `rol`, `username`, `id_country_house_fk`) VALUES ('3', 'contra123', '1', 'user_three', '3');
INSERT INTO `accounts` (`id`, `password`, `rol`, `username`, `id_country_house_fk`) VALUES ('4', 'contra123', '1', 'user_four', '4');



INSERT INTO products (product_id, product_name, product_category, temperature, validated) VALUES ('1','Carne', '1', 0.0, '2021-05-21');
INSERT INTO products (product_id, product_name, product_category, temperature, validated) VALUES ('2','Peixe', '2', 0.0, '2021-05-21');
INSERT INTO products (product_id, product_name, product_category, temperature, validated) VALUES ('3','Maca', '3', 0.0, '2021-05-21');

INSERT INTO batch (batch_id,current_temperature,min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk) VALUES ('1', '-5.0', '-8.0', '2021-05-21', '2021-05-21', '50', '50', '2021-05-21','1');
INSERT INTO batch (batch_id,current_temperature,min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk) VALUES ('2', '0.0', '8.0', '2021-03-21', '2021-03-21', '40', '60', '2021-05-21','2');
INSERT INTO batch (batch_id,current_temperature,min_temperature, manufacturing_date,
manufacturing_time, initial_quantity, current_quantity, due_date, product_id_fk) VALUES ('3', '-5.0', '-8.0', '2021-05-21', '2021-05-21', '15', '25', '2021-05-21','3');


--INSERT INTO `products` (`product_id` , `product_category`,`validated`,  )