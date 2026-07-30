SELECT c.name,
       o.id
FROM customers c
FULL OUTER JOIN orders o
ON c.id = o.customer_id;

SELECT e.FIRST_NAME,
       p.project_name
FROM employees e
FULL OUTER JOIN projects_assigned p
ON e.employee_id = p.employee_id;

SELECT p.name,
       s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s
ON p.supplier_id = s.supplier_id;

SELECT s.name,
       c.course_name
FROM students s
FULL OUTER JOIN courses c
ON s.course_id = c.course_id;

SELECT a.author_name,
       b.book_title
FROM authors a
FULL OUTER JOIN books b
ON a.author_id = b.author_id;

SELECT e.FIRST_NAME,
       d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON e.department_id = d.department_id;

SELECT t.transaction_id,
       p.payment_status
FROM transactions t
FULL OUTER JOIN payment_methods p
ON t.payment_method_id = p.payment_method_id;

SELECT r1.customer_name AS region1_customer,
       r2.customer_name AS region2_customer
FROM customers_region1 r1
FULL OUTER JOIN customers_region2 r2
ON r1.customer_id = r2.customer_id;