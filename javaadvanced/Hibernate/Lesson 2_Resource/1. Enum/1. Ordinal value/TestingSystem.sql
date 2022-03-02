-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Article
DROP TABLE IF EXISTS Article;
CREATE TABLE Article(
	id 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
    `status` 			ENUM('0','1','2','3') NOT NULL -- 0: Open, 1: Review, 2: Approved, 3: rejected
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Article
INSERT INTO Article		(title,		 	`status`) 
VALUES
						('Article 1',		'0'	),
						('Article 2',		'1'	),
						('Article 3',		'2'	);
                        
                        