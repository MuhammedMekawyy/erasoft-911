/*
create Teacher with 
id name salary

create Language with
id name 

Teacher has only Language
Language has many Teacher

- please create classes with relation */ 

CREATE TABLE language (
    id NUMBER(6) CONSTRAINT pk_language PRIMARY KEY,
    name VARCHAR2(50)
);

CREATE TABLE teacher (
    id NUMBER(6) CONSTRAINT pk_teacher PRIMARY KEY,
    name VARCHAR2(50),
    salary NUMBER(9),
    language_id NUMBER(6),

    CONSTRAINT fk_teacher_language
        FOREIGN KEY (language_id)
        REFERENCES language(id)
);