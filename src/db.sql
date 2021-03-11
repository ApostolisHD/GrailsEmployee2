CREATE TABLE departments(
                          department_id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(10)
)

CREATE TABLE employee(
                         employee_id BIGSERIAL PRIMARY KEY,
                         id_dep BIGINT,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         afm VARCHAR(9) unique NOT NULL,
                         date_of_birth DATE NOT null,
                         CONSTRAINT fk_dep FOREIGN KEY(id_dep) REFERENCES departments(department_id)
)

create table users(
                      user_id BIGSERIAL PRIMARY key,
                      user_name varchar(50) unique not null,
                      user_password varchar (50) not null,
                      user_active boolean not null
)