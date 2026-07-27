/*PLS create Player table with
id name age
- make id not null
- make id unique
- make name unique*/  

CREATE TABLE player (
    id NUMBER(6) CONSTRAINT not_null_player_id NOT NULL,
    name VARCHAR2(150),

    CONSTRAINT uniq_player_id UNIQUE (id),
    CONSTRAINT uniq_player_name UNIQUE (name)
);

/* pls create Manger with
id name salary
-id must be not null
-id and name must be unique together
*/ 

CREATE TABLE manager ( 

id number(6) CONSTRAINT not_null_manager_id NOT NULL, 
name varchar2(50),
salary number(9),

CONSTRAINT composite_manager_id_name UNIQUE (id,name)

);


CREATE TABLE managerr (
    id NUMBER(10) CONSTRAINT pk_manager PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER(3)
);