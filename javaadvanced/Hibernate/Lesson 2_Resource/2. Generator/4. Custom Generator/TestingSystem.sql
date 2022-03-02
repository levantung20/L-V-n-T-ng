-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Article
DROP TABLE IF EXISTS Article;
CREATE TABLE Article(
	 `code` 			VARCHAR(50) PRIMARY KEY, -- code = type-count
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
    `type`				NVARCHAR(50) NOT NULL
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Article
INSERT INTO Article		(`code`, 		title		, 	`type`		) 
VALUE
						(	'J-1'	,	'Java 1 Exam'	,	'Java'	),
						(	'S-1'	,	'SQL Exam'		,	'SQL'	),
						(	'J-2'	,	'Java 2 Exam'	,	'Java'	);