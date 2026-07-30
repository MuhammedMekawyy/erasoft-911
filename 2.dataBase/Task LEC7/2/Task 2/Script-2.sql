SELECT d.department_name,
       e.FIRST_NAME
FROM employees e
RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;

SELECT o.id,
       c.name
FROM orders o
RIGHT OUTER JOIN customers c
ON o.customer_id = c.id;

SELECT c.course_name,
       s.name
FROM students s
RIGHT OUTER JOIN courses c
ON s.course_id = c.course_id;

SELECT p.project_name,
       e.FIRST_NAME
FROM employees e
RIGHT OUTER JOIN projects_assigned p
ON e.employee_id = p.employee_id;

SELECT p.payment_status,
       i.invoice_id
FROM invoices i
RIGHT OUTER JOIN payments p
ON i.invoice_id = p.invoice_id;

SELECT a.author_name,
       b.book_title
FROM books b
RIGHT OUTER JOIN authors a
ON b.author_id = a.author_id;

SELECT c.category_name,
       p.name
FROM products p
RIGHT OUTER JOIN categories c
ON p.category_id = c.category_id;

SELECT s.name,
       d.room_number
FROM students s
RIGHT OUTER JOIN dorm_rooms d
ON s.room_id = d.room_id;