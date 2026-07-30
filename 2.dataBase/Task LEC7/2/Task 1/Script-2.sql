SELECT e.FIRST_NAME,
       d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

SELECT p.name,
       c.category_name
FROM products p
LEFT OUTER JOIN categories c
ON p.category_id = c.category_id;

SELECT s.name,
       c.course_name
FROM students s
LEFT OUTER JOIN courses c
ON s.course_id = c.course_id;

SELECT o.id,
       c.name
FROM orders o
LEFT OUTER JOIN customers c
ON o.customer_id = c.id;

SELECT d.department_name,
       m.manager_name
FROM departments d
LEFT OUTER JOIN managers m
ON d.manager_id = m.manager_id;

SELECT b.book_title,
       a.author_name
FROM books b
LEFT OUTER JOIN authors a
ON b.author_id = a.author_id;

SELECT i.invoice_id,
       p.payment_status
FROM invoices i
LEFT OUTER JOIN payments p
ON i.invoice_id = p.invoice_id;

SELECT e.FIRST_NAME,
       p.project_name
FROM employees e
LEFT OUTER JOIN projects_assigned p
ON e.employee_id = p.employee_id;