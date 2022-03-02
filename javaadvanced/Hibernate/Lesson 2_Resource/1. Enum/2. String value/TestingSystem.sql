-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Article
DROP TABLE IF EXISTS Article;
CREATE TABLE Article(
	id 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
    `status` 			ENUM('OPEN','REVIEW','APPROVED','REJECTED') NOT NULL
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Article
INSERT INTO Article		(title,		 	`status`		) 
VALUES
						('Article 1',		'OPEN'		),
						('Article 2',		'REVIEW'	),
						('Article 3',		'APPROVED'	);
                        
                        