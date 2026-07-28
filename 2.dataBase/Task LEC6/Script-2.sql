CREATE TABLE hamada( 

age number(3)

CONSTRAINT check_hamada_age 
CHECK (age>=18)
);


CREATE TABLE staff( 

salary number(9)

CONSTRAINT check_staff_salary 
CHECK (salary BETWEEN 1000 AND 3000)
);


DELETE FROM products
WHERE price <= 0;

ALTER TABLE PRODUCTS 
ADD CONSTRAINT positive_products_price_check
CHECK (price>0);  

CREATE TABLE students (
    grade CHAR(1),

    CONSTRAINT chk_student_grade
        CHECK (grade IN ('A', 'B', 'C', 'D', 'E', 'F'))
);

/*-----------------------------------------------------------------*/





ALTER TABLE users
ADD CONSTRAINT uq_users_username
UNIQUE (username);

ALTER TABLE customers
ADD CONSTRAINT pk_customers
PRIMARY KEY (id);

ALTER TABLE orders
ADD CONSTRAINT fk_orders_customer
FOREIGN KEY (customer_id)
REFERENCES customers(id);

ALTER TABLE accounts
ADD CONSTRAINT chk_accounts_balance
CHECK (balance >= 0);

ALTER TABLE departmentsss
ADD CONSTRAINT pk_departments
PRIMARY KEY (dept_id);


/*-----------------------------------------------------------------------------*/

ALTER TABLE users
DROP  CONSTRAINT uq_users_username;


ALTER TABLE products
DROP  CONSTRAINT pk_products;

ALTER TABLE orders
DROP CONSTRAINT fk_orders_customer;

ALTER TABLE EMPLOYEES 
DROP CONSTRAINT EMP_EMAIL_NN;


/*--------------------------------------------------------*/

ALTER TABLE students
RENAME CONSTRAINT chk_age
TO check_min_age;

ALTER TABLE employees
RENAME CONSTRAINT fk_emp_dept
TO fk_employee_department;

ALTER TABLE users
RENAME CONSTRAINT pk_users
TO pk_users_id;

ALTER TABLE users
RENAME CONSTRAINT uq_users_username
TO uk_user_name;

/*SQL Server	EXEC sp_rename 'table.old_constraint_name', 'new_constraint_name', 'OBJECT';
PostgreSQL	ALTER TABLE table_name RENAME CONSTRAINT old_constraint_name TO new_constraint_name; */ 

/*---------------------------------------------------------*/


ALTER TABLE orders
DISABLE CONSTRAINT fk_customer_order;

ALTER TABLE products
DISABLE CONSTRAINT POSITIVE_PRODUCTS_PRICE_CHECK;

ALTER TABLE accounts
DISABLE CONSTRAINT chk_accounts_balance;

ALTER TABLE departmentsss
DISABLE CONSTRAINT PK_DEPARTMENTS;

/*In Oracle, there is no single command to disable all constraints on a table*/ 

/*----------------------------------------------------------------------------------------------*/



ALTER TABLE orders
ENABLE  CONSTRAINT fk_customer_order;

ALTER TABLE products
ENABLE  CONSTRAINT POSITIVE_PRODUCTS_PRICE_CHECK;

ALTER TABLE accounts
ENABLE  CONSTRAINT chk_accounts_balance;

ALTER TABLE departmentsss
ENABLE  CONSTRAINT PK_DEPARTMENTS;








