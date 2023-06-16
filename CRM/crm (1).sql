create database crm_app
go
USE crm_app;
go
CREATE TABLE roles (
    id INT NOT NULL identity(1,1),
    name NVARCHAR(50) NOT NULL,
    description NVARCHAR(100),
    PRIMARY KEY (id)
);
go
CREATE TABLE users (
    id INT NOT NULL identity(1,1),
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullname NVARCHAR(100) NOT NULL,
    avatar VARCHAR(MAX),
	status int,
    role_id INT NOT NULL,
    PRIMARY KEY (id)
);
go
CREATE TABLE status (
    id INT NOT NULL identity(1,1),
    name NVARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
go
CREATE TABLE jobs (
    id INT NOT NULL identity(1,1),
    name NVARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY (id)
);
go
CREATE TABLE tasks (
    id INT NOT NULL identity(1,1),
    name NVARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    user_id INT NOT NULL,
    job_id INT NOT NULL,
    status_id INT NOT NULL,
    PRIMARY KEY (id)
);
go
ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (user_id) REFERENCES users (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (job_id) REFERENCES jobs (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (status_id) REFERENCES status (id)  ON DELETE CASCADE;

INSERT INTO roles( name, description ) VALUES ('ROLE_ADMIN', N'Quản trị hàng tháng');
INSERT INTO roles( name, description ) VALUES ('ROLE_MANAGER', N'Quản lý');
INSERT INTO roles( name, description ) VALUES ('ROLE_USER', N'Nhân viên');

INSERT INTO users(email, password, fullname, avatar, status, role_id) VALUES('a@gmail.com','1', 'Nguyen Van A', 'https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2023/02/Hinh-anh-avatar-Facebook.jpg?ssl=1', 1, 1);
INSERT INTO users(email, password, fullname, avatar, status, role_id) VALUES('b@gmail.com','1', 'Nguyen Van B', 'https://scr.vn/wp-content/uploads/2020/07/h%C3%ACnh-%C4%91%E1%BA%A1i-di%E1%BB%87n-cute-cho-con-trai.jpg', 1, 2);
INSERT INTO users(email, password, fullname, avatar, status, role_id) VALUES('c@gmail.com','1', 'Nguyen Van C', 'https://hinhanhdephd.com/wp-content/uploads/2021/03/anime-nam-cute.jpg', 1, 3);

INSERT INTO jobs(name, start_date, end_date) VALUES('Job1', '2022-10-10','2023-03-27');
INSERT INTO jobs(name, start_date, end_date) VALUES('Job2', '2022-03-27','2023-05-11');
INSERT INTO jobs(name, start_date, end_date) VALUES('Job3', '2022-05-11','2023-10-10');

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id) VALUES('Task1', '2022-10-10','2023-03-27', 1, 1, 1);
INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id) VALUES('Task2', '2022-03-27','2023-05-11', 2, 2, 2);
INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id) VALUES('Task3', '2022-05-11','2023-10-10', 3, 3, 3);


INSERT INTO status( name ) VALUES (N'Chưa thực hiện');
INSERT INTO status( name ) VALUES (N'Đang thực hiện');
INSERT INTO status( name ) VALUES (N'Đã hoàn thành');

select * from users
select * from roles
select * from jobs
select * from tasks

select u.id, u.email, u.password, u.fullname, u.avatar, u.status, u.role_id, r.name 
from users as u left join roles as r on u.role_id = r.id
where u.email='a@gmail.com' and u.password = '1'

update roles set description =N'Quản lý hệ thống' where id=1