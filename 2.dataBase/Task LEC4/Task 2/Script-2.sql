SELECT REPLACE('database','a','#') FROM dual;

SELECT REPLACE('Mekawy old','old','new') FROM dual;

CREATE TABLE PRODUCTS ( 
product_name varchar2(50)
);

INSERT INTO PRODUCTS(product_name) VALUES ('apple');
INSERT INTO PRODUCTS(product_name) VALUES ('banana');
INSERT INTO PRODUCTS(product_name) VALUES ('carrot');

SELECT LPAD(product_name,15,'*') FROM PRODUCTS ;

SELECT RPAD(product_name,15,'#') FROM PRODUCTS ;



