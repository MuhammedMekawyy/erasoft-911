/*Find the names of employees who earn more than the average salary.
Use a subquery to calculate the average salary.*/ 

SELECT first_name
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
);

SELECT customer_id,
       COUNT(*) AS total_orders
FROM orders
GROUP BY customer_id
HAVING COUNT(*) = (
    SELECT MAX(order_count)
    FROM (
        SELECT COUNT(*) AS order_count
        FROM orders
        GROUP BY customer_id
    )
);

SELECT name,
       price
FROM products
WHERE price > ANY (
    SELECT price
    FROM products
    WHERE category_name = 'Accessories'
);

SELECT first_name
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE first_name = 'John Smith'
);

SELECT *
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city = 'New York'
);

SELECT department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT *
    FROM employees e
    WHERE e.department_id = d.department_id
);

SELECT name
FROM students s
WHERE NOT EXISTS (
    SELECT *
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

SELECT MAX(salary)
FROM employees
WHERE salary < (
    SELECT MAX(salary)
    FROM employees
);

SELECT name,
       price
FROM products
WHERE price > (
    SELECT AVG(price)
    FROM products
);

SELECT c.name
FROM customers c
WHERE NOT EXISTS (
    SELECT id
    FROM products
    WHERE category_name = 'A'
      AND NOT EXISTS (
          SELECT *
          FROM orders o
          WHERE o.customer_id = c.id
            AND o.id = products.id
      )
);
