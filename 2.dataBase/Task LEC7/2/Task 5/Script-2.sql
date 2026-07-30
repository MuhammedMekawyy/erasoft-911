SELECT first_name,
       salary
FROM employees
WHERE salary = (
    SELECT MAX(salary)
    FROM employees
); 



SELECT first_name
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE first_name = 'Alice'
);

SELECT *
FROM products
WHERE price = (
    SELECT MIN(price)
    FROM products
);

SELECT department_name
FROM departments
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE salary = (
        SELECT MAX(salary)
        FROM employees
    )
);

SELECT m.first_name AS manager_name
FROM employees m
WHERE m.employee_id = (
    SELECT manager_id
    FROM employees
    WHERE hire_date = (
        SELECT MAX(hire_date)
        FROM employees
    )
);

SELECT first_name,
       salary
FROM employees
WHERE salary = (
    SELECT AVG(salary)
    FROM employees
);

SELECT *
FROM orders
WHERE order_date = (
    SELECT MIN(order_date)
    FROM orders
);

SELECT first_name,
       salary
FROM employees
WHERE salary > (
    SELECT salary
    FROM employees
    WHERE employee_id = 101
);

SELECT name
FROM students
WHERE marks = (
    SELECT marks
    FROM students
    WHERE name = 'John Doe'
);

SELECT *
FROM books
WHERE price = (
    SELECT MAX(price)
    FROM books
    WHERE category = 'Science'
);