SELECT country_id,
       country_name,
       city
FROM locations
NATURAL JOIN countries;

SELECT country_id,
       country_name,
       city
FROM locations
JOIN countries
USING (country_id);

SELECT l.location_id,
       l.city,
       c.country_id,
       c.country_name
FROM locations l
JOIN countries c
ON l.country_id = c.country_id;

SELECT l.location_id,
       l.city,
       c.country_name
FROM locations l
INNER JOIN countries c
ON l.country_id = c.country_id;

SELECT l.location_id,
       l.city,
       c.country_name
FROM locations l
LEFT OUTER JOIN countries c
ON l.country_id = c.country_id;

SELECT l.location_id,
       l.city,
       c.country_name
FROM locations l
RIGHT OUTER JOIN countries c
ON l.country_id = c.country_id;

SELECT l.location_id,
       l.city,
       c.country_name
FROM locations l
FULL OUTER JOIN countries c
ON l.country_id = c.country_id;