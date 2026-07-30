SELECT job_id,
       job_title,
       start_date,
       end_date,
       employee_id
FROM jobs
NATURAL JOIN job_history;

SELECT job_id,
       job_title,
       start_date,
       end_date,
       employee_id
FROM jobs
JOIN job_history
USING (job_id);

SELECT j.job_id,
       j.job_title,
       h.employee_id,
       h.start_date,
       h.end_date
FROM jobs j
JOIN job_history h
ON j.job_id = h.job_id;

SELECT j.job_id,
       j.job_title,
       h.employee_id
FROM jobs j
INNER JOIN job_history h
ON j.job_id = h.job_id;

SELECT j.job_id,
       j.job_title,
       h.employee_id
FROM jobs j
LEFT OUTER JOIN job_history h
ON j.job_id = h.job_id;

SELECT j.job_id,
       j.job_title,
       h.employee_id
FROM jobs j
RIGHT OUTER JOIN job_history h
ON j.job_id = h.job_id;

SELECT j.job_id,
       j.job_title,
       h.employee_id
FROM jobs j
FULL OUTER JOIN job_history h
ON j.job_id = h.job_id;

SELECT country_id,
       country_name,
       city
FROM countries
NATURAL JOIN locations;

SELECT country_id,
       country_name,
       city
FROM countries
JOIN locations
USING (country_id);

SELECT c.country_id,
       c.country_name,
       l.city
FROM countries c
JOIN locations l
ON c.country_id = l.country_id;

SELECT c.country_id,
       c.country_name,
       l.city
FROM countries c
INNER JOIN locations l
ON c.country_id = l.country_id;

SELECT c.country_id,
       c.country_name,
       l.city
FROM countries c
LEFT OUTER JOIN locations l
ON c.country_id = l.country_id;

SELECT c.country_id,
       c.country_name,
       l.city
FROM countries c
RIGHT OUTER JOIN locations l
ON c.country_id = l.country_id;

SELECT c.country_id,
       c.country_name,
       l.city
FROM countries c
FULL OUTER JOIN locations l
ON c.country_id = l.country_id;