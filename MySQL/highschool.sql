DROP DATABASE IF EXISTS highschool;
CREATE DATABASE highschool;
USE highschool;

DROP TABLE IF EXISTS class;
CREATE TABLE class (
	id INT UNSIGNED AUTO_INCREMENT,
    class_name VARCHAR(10) UNIQUE NOT NULL,
    student_number INT, 
    create_at DATE, 
    update_at DATE,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS student;
CREATE TABLE student (
	id INT UNSIGNED AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL, 
    last_name VARCHAR(50) NOT NULL, 
    email VARCHAR(50) UNIQUE, 
    gender ENUM('MALE', 'FEMALE'), 
    address VARCHAR(50), 
    class_id INT UNSIGNED NOT NULL, 
    create_at DATE, 
    update_at DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (class_id) REFERENCES class(id)
);

DROP TRIGGER IF EXISTS after_students_insert;
DELIMITER $$
-- BEGIN
CREATE TRIGGER after_students_insert
AFTER INSERT
ON student FOR EACH ROW
BEGIN
	UPDATE `class` c
    SET `student_number` = `student_number` + 1 
    WHERE (c.id = NEW.class_id);
END $$
DELIMITER ;

INSERT INTO class (class_name, student_number, create_at) 
VALUES  ('10A', 0, '2019-12-31'),
		('10B', 0, '2019-12-31'),
        ('10C', 0, '2019-12-31'),
        ('11A', 0, '2019-12-31'),
        ('11B', 0, '2019-12-31'),
        ('11C', 0, '2019-12-31'),
        ('12A', 0, '2019-12-31'),
        ('12B', 0, '2019-12-31'),
        ('12C', 0, '2019-12-31');

insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Hong', 'Hanh', 'hanhnh@yahoo.com', 'Female', '48 Kenwood Plaza', 6, '2021-01-16');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Cao Thuy', 'Tien', 'tienct@yahoo.com', 'Female', '54 Goodland Lane', 9, '2020-11-17');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Doan Ngoc', 'Tram', 'tramdn@yahoo.com', 'Female', '5 Granby Avenue', 1, '2021-06-22');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Mai Duc', 'Son', 'sonmd@yahoo.com', 'Male', '7107 Stoughton Terrace', 3, '2021-06-05');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Hoang', 'Minh', 'minhnh@yahoo.com', 'Male', '42 Glacier Hill Alley', 9, '2021-05-04');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Ho Thanh', 'Thuy', 'thuyht@yahoo.com', 'Female', '7176 Eagle Crest Center', 8, '2021-06-05');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Chau', 'Giang', 'giangnc@yahoo.com', 'Female', '4426 Coolidge Place', 9, '2020-11-26');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Tran Tri', 'Dung', 'dungtt@yahoo.com', 'Male', '693 Paget Crossing', 1, '2021-05-20');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Ha Hue', 'Chi', 'chihh@yahoo.com', 'Female', '5241 Iowa Court', 6, '2021-04-25');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Huyen', 'Trang', 'trangnh@yahoo.com', 'Female', '89095 Transport Trail', 8, '2020-09-07');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Pham Tiet', 'Nguyen', 'nguyenpt@yahoo.com', 'Male', '1965 Manley Drive', 9, '2020-08-13');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Vu Nguyet', 'Minh', 'minhvn@yahoo.com', 'Female', '70 Holy Cross Hill', 5, '2020-08-15');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Ha Hong', 'Loan', 'loanhh@yahoo.com', 'Female', '7932 Morningstar Terrace', 3, '2021-03-23');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Bui Viet', 'My', 'mybv@yahoo.com', 'Female', '2 Meadow Vale Plaza', 8, '2020-08-24');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Chau Kien', 'Hung', 'hungck@yahoo.com', 'Male', '7573 Fairfield Trail', 2, '2020-08-16');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Le Thanh', 'Duy', 'duylt@yahoo.com', 'Male', '90168 Burrows Hill', 2, '2020-12-19');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Bui Minh', 'Thu', 'thubm@yahoo.com', 'Female', '43166 Sullivan Point', 9, '2021-02-18');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Cao Huy', 'Cuong', 'cuonghc@yahoo.com', 'Male', '341 Hanson Hill', 1, '2020-11-09');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Pham Ngoc', 'Tuong', 'tuongcbc@yahoo.com', 'Male', '3 Rockefeller Trail', 7, '2020-09-08');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Vu Quang', 'Huy', 'huyqv@yahoo.com', 'Male', '3 Cascade Place', 6, '2021-03-25');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Tran Ngoc', 'Quynh', 'quynhtn@yahoo.com', 'Female', '9 Fairview Hill', 6, '2021-01-01');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Yen', 'Trang', 'trangny@yahoo.com', 'Female', '2 Oak Plaza', 8, '2020-08-16');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Ngoc', 'Quyet', 'quyetnn@yahoo.com', 'Male', '56 Eagle Crest Alley', 7, '2021-07-19');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Hoang Quynh', 'Yen', 'yenqh@yahoo.com', 'Female', '352 Namekagon Place', 1, '2020-09-17');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Tran Tien', 'Thanh', 'thanhtt@yahoo.com', 'Male', '9 Almo Terrace', 8, '2021-04-18');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Pham Ngoc', 'Dong', 'dongpn@yahoo.com', 'Male', '85 Monument Crossing', 5, '2020-09-21');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Hoang Phuong', 'Thao', 'thaohp@yahoo.com', 'Female', '27290 Washington Trail', 5, '2020-09-18');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Ngo Ngoc', 'Linh', 'linhnn@yahoo.com', 'Female', '0055 Hooker Park', 5, '2021-03-28');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Vu Kieu', 'Ngan', 'nganvk@yahoo.com', 'Female', '9 Golf View Way', 1, '2020-09-23');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Phung Thi', 'Phuong', 'phuongpt@yahoo.com', 'Female', '8 Summer Ridge Pass', 8, '2021-07-05');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Trinh Duy', 'Quang', 'tdquang@yahoo.com', 'Male', '107 Lakeland Pass', 7, '2021-05-13');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Hai', 'Anh', 'nhanh@yahoo.com', 'Female', '81381 Marquette Drive', 4, '2020-10-08');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Tran Ngoc', 'Duc', 'ductn@yahoo.com', 'Male', '7117 Ilene Trail', 4, '2021-05-04');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Trung', 'Hieu', 'hieunt@yahoo.com', 'Male', '15 Prairie Rose Hill', 4, '2021-07-31');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Duc', 'Nam', 'namnd@yahoo.com', 'Male', '7053 Browning Trail', 4, '2021-03-12');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Do Thuy', 'Ha', 'hadt@yahoo.com', 'Female', '18262 Mandrake Circle', 1, '2020-10-22');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Pham Quynh', 'Trang', 'trangpq@yahoo.com', 'Female', '8 Drewry Circle', 9, '2021-06-30');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Dang Thi Thu', 'Ha', 'hadtt@yahoo.com', 'Female', '816 Anzinger Hill', 4, '2021-07-19');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Do Ngoc', 'Trung', 'trungdn@yahoo.com', 'Male', '837 Stoughton Drive', 5, '2021-05-04');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Ngo Duc', 'Thao', 'thaond@yahoo.com', 'Female', '618 Old Shore Plaza', 9, '2021-01-19');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Hong', 'Giang', 'giangnh@yahoo.com', 'Male', '3 Oriole Court', 1, '2020-12-14');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Ky', 'Anh', 'kyanhn@yahoo.com', 'Male', '1 Barby Place', 7, '2021-01-07');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Ba', 'Hung', 'bahungn@yahoo.com', 'Male', '1144 Emmet Drive', 8, '2021-05-17');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Pham Thanh', 'An', 'anpt@yahoo.com', 'Female', '839 Gale Center', 2, '2021-04-20');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Trinh Hoang', 'Nam', 'namth@yahoo.com', 'Male', '71 Mayfield Junction', 7, '2021-01-14');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Trinh Thu', 'Trang', 'trinhtrang@yahoo.com', 'Female', '58808 Dwight Court', 3, '2021-07-20');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Tran Minh', 'Tung', 'tungtm@yahoo.com', 'Male', '2 Manitowish Street', 2, '2021-08-02');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Le Hoai', 'Thuong', 'thuonglh@yahoo.com', 'Female', '39019 Barby Hill', 7, '2020-09-05');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Le Thanh', 'Trung', 'trunglt@yahoo.com', 'Male', '4 American Parkway', 3, '2021-02-02');
insert into student (first_name, last_name, email, gender, address, class_id, create_at) values ('Nguyen Thanh', 'Phuong', 'phuongnt@yahoo.com', 'Female', '19 Dwight Avenue', 5, '2020-08-21');


        
