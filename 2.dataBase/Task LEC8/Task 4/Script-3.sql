CREATE TABLE student (
	id NUMBER,
	name varchar(255)
);

INSERT INTO student values( 1 , 'ahmed');
INSERT INTO student values( 2 , 'mohamed');

DELETE FROM
student WHERE id=1;

UPDATE student 
SET name='mekawy'
WHERE id=2;

SELECT * FROM STUDENT;


