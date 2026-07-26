CREATE TABLE customers (
    full_name VARCHAR2(50)
);


INSERT INTO customers VALUES ('   Ahmed Ali');
INSERT INTO customers VALUES ('Sara Mohamed   ');
INSERT INTO customers VALUES ('   Omar Hassan   ');
INSERT INTO customers VALUES ('Mona Adel');



SELECT TRIM(full_name) 
FROM customers;


SELECT LTRIM(full_name)
FROM customers;


SELECT RTRIM(full_name) 
FROM customers;


SELECT TRIM('$' FROM '$$$Oracle$$$') AS result FROM dual;
SELECT TRIM('*' FROM '***Oracle***') AS result FROM dual;
SELECT TRIM('#' FROM '###Oracle###') AS result FROM dual;


/********************************************************************
2. Character Functions – Part 4 (REPLACE, LPAD, RPAD)
********************************************************************/


SELECT REPLACE('promotion','o','0') 
FROM dual;


SELECT REPLACE('This is a basic course',
               'basic',
               'advanced') 
FROM dual;


SELECT LPAD(DEPARTMENT_NAME,15,'*') 
FROM departments;


SELECT RPAD(DEPARTMENT_NAME,15,'-') 
FROM departments;


/********************************************************************
3. TO_CHAR Function
********************************************************************/

-- Current Date
SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY')
FROM dual;

-- Day, Month Year
SELECT TO_CHAR(SYSDATE,'Day, Month YYYY')
FROM dual;

-- Number Formatting
SELECT TO_CHAR(1234567.89,'9,999,999.99')
FROM dual;

-- Salary Formatting
SELECT TO_CHAR(8500,'$99,999.99')
FROM dual;

-- Date and Time
SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI:SS')
FROM dual;


/********************************************************************
4. Oracle Conditional Expressions – CASE
********************************************************************/

SELECT name,
       MARKS,
       CASE
           WHEN MARKS >= 90 THEN 'A'
           WHEN MARKS >= 80 THEN 'B'
           WHEN MARKS >= 70 THEN 'C'
           ELSE 'F'
       END 
FROM students;


SELECT name,
       MARKS,
       CASE
           WHEN MARKS >= 60 THEN 'Pass'
           ELSE 'Fail'
       END
FROM students;


SELECT name,
       MARKS,
       CASE
           WHEN MARKS >= 90 THEN 'Excellent'
           WHEN MARKS >= 80 THEN 'Good'
           WHEN MARKS >= 70 THEN 'Average'
           ELSE 'Needs Improvement'
       END 
FROM students;


SELECT CASE TO_CHAR(SYSDATE,'DAY')
           WHEN 'MONDAY   ' THEN 'Today is Monday'
           WHEN 'TUESDAY  ' THEN 'Today is Tuesday'
           WHEN 'WEDNESDAY' THEN 'Today is Wednesday'
           WHEN 'THURSDAY ' THEN 'Today is Thursday'
           WHEN 'FRIDAY   ' THEN 'Today is Friday'
           WHEN 'SATURDAY ' THEN 'Today is Saturday'
           WHEN 'SUNDAY   ' THEN 'Today is Sunday'
       END 
FROM dual;


/********************************************************************
5. Oracle Conditional Expressions – DECODE
********************************************************************/


SELECT name,
       MARKS,
       DECODE(MARKS,
              100,'A',
              90,'B',
              80,'C',
              'F') 
FROM students;



CREATE TABLE status_log (
    status_code CHAR(1)
);


INSERT INTO status_log VALUES ('N');
INSERT INTO status_log VALUES ('I');
INSERT INTO status_log VALUES ('C');



SELECT status_code,
       DECODE(status_code,
              'N','New',
              'I','In Progress',
              'C','Completed',
              'Unknown') 
FROM status_log;



CREATE TABLE productss (
    product_name VARCHAR2(30),
    quantity NUMBER
);


INSERT INTO productss VALUES ('Mouse',10);
INSERT INTO productss VALUES ('Keyboard',0);
INSERT INTO productss VALUES ('Monitor',5);



SELECT product_name,
       quantity,
       DECODE(quantity,
              0,'Out of Stock',
              'Available') 
FROM productss;



SELECT FIRSTNAME,
       department,
       DECODE(department,
              'HR',500,
              'IT',1000,
              'Sales',1500,
              300) AS bonus
FROM EMPLOYEESS;