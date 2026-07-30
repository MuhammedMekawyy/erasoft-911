/*Find all employees who earn more than at least one employee in department 10.
Use a subquery with ANY or SOME.*/ 
SELECT first_name 
FROM employees 
WHERE salary > (  
     SELECT min(SALARY) 
     FROM employees 
     WHERE department_id = 50
); 

SELECT first_name,
       salary
FROM employees
WHERE salary < ALL (
    SELECT salary
    FROM employees
    WHERE department_id = 20
);

SELECT name,
       price
FROM products
WHERE price IN (
    SELECT price
    FROM products
    WHERE category_name = 'Electronics'
);

SELECT name
FROM customers
WHERE id IN (
    SELECT customer_id
    FROM orders
    WHERE id IN (
        SELECT id
        FROM products
        WHERE price > 1000
    )
);

SELECT first_name,
       job_id
FROM employees
WHERE job_id IN (
    SELECT job_id
    FROM employees
    GROUP BY job_id
    HAVING COUNT(*) > 1
);

SELECT department_name
FROM departments
WHERE department_id IN (
    SELECT department_id
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) > 1
);

SELECT *
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city IN (
        SELECT city
        FROM customers
        GROUP BY city
        HAVING COUNT(*) > 1
    )
);

SELECT book_title
FROM books
WHERE author_id IN (
    SELECT author_id
    FROM books
    GROUP BY author_id
    HAVING COUNT(*) > 1
);

SELECT name
FROM students
WHERE course_id IN (
    SELECT course_id
    FROM courses
    WHERE professor_name = 'Dr. Smith'
);

SELECT first_name,
       salary
FROM employees
WHERE salary IN (
    SELECT salary
    FROM employees
    WHERE department_id = 30
);