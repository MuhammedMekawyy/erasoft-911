SELECT e.FIRST_NAME,
       m.FIRST_NAME AS manager_name
FROM employees e
JOIN employees m
ON e.manager_id = m.employee_id;

SELECT c.name AS customer_name,
       e.FIRST_NAME AS salesperson_name
FROM customers c
JOIN employees e
ON c.id = e.employee_id;

SELECT o.id,
       od.product_id
FROM orders o
JOIN order_details od
ON o.id = od.order_id;

SELECT s.name AS student_name,
       i.name AS instructor_name
FROM students s
JOIN instructors i
ON s.instructor_id = i.instructor_id;

SELECT e.salary,
       d.budget
FROM employees e
JOIN departments d
ON e.department_id = d.department_id;

SELECT p.name AS project_name,
       t.name AS task_name
FROM projects p
JOIN tasks t
ON p.project_id = t.project_id;

SELECT c.course_name,
       c.course_date,
       e.exam_date
FROM courses c
JOIN exams e
ON c.course_id = e.course_id;

SELECT p.name AS product_name,
       c.name AS category_name
FROM products p
JOIN categories c
ON p.category_id = c.category_id;

SELECT b.title AS book_title,
       p.name AS publisher_name
FROM books b
JOIN publishers p
ON b.publisher_id = p.publisher_id;

SELECT e.name AS employee_name,
       d.location AS department_location
FROM employees e
JOIN departments d
ON e.department_id = d.department_id;