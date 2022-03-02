-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Order
DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (
	order_id			SMALLINT UNSIGNED NOT NULL,		
    product_id 			SMALLINT UNSIGNED NOT NULL,
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
	PRIMARY KEY (order_id, product_id)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Order
INSERT INTO `Order`		(order_id		, 	product_id		, 	title		) 
VALUE
						(	1			,		1			,	'Order 1'	),
						(	1			,		2			,	'Order 2'	),
						(	2			,		3			,	'Order 3'	);
                        
                        
                        