CREATE TABLE phone (
    id NUMBER(6) CONSTRAINT pk_phone PRIMARY KEY,
    phone_number VARCHAR2(20)
);

CREATE TABLE employee (
    id NUMBER(6) CONSTRAINT pk_employee PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER(3),
    phone_id NUMBER(6) CONSTRAINT not_null_employee_phone NOT NULL,
    
    
    CONSTRAINT uniq_employee_phone UNIQUE (phone_id),

    CONSTRAINT fk_employee_phone
        FOREIGN KEY (phone_id)
        REFERENCES phone(id)
);