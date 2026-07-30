SELECT first_name,
       department_name
FROM employees
NATURAL JOIN departments;

SELECT id,
       name
FROM orders
NATURAL JOIN customers;

SELECT student_name,
       course_name
FROM students
NATURAL JOIN courses;

SELECT project_name,
       employee_name
FROM projects
NATURAL JOIN employees;

SELECT invoice_id,
       product_name
FROM invoices
NATURAL JOIN products;

SELECT book_title,
       author_name
FROM books
NATURAL JOIN authors;

SELECT class_name,
       instructor_name,
       schedule_date
FROM class_schedules
NATURAL JOIN instructors;

SELECT supplier_name,
       product_name
FROM suppliers
NATURAL JOIN products;

SELECT order_id,
       customer_name,
       shipping_address,
       shipping_date
FROM orders
NATURAL JOIN shipping;

SELECT first_name,
       job_title
FROM employees
NATURAL JOIN jobs;