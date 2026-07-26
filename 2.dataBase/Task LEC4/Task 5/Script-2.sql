SELECT DECODE(SIGN(MARKS - 90),
              1, 'A',
              0, 'A',
              DECODE(SIGN(MARKS - 80),
                     1, 'B',
                     0, 'B',
                     DECODE(SIGN(MARKS - 70),
                            1, 'C',
                            0, 'C',
                            'F')))
FROM STUDENTS; 


CREATE TABLE orders ( 

status char

); 
INSERT INTO orders VALUES ('P');  
INSERT INTO orders VALUES ('S');  
INSERT INTO orders VALUES ('D');  
INSERT INTO orders VALUES ('C');  
INSERT INTO orders VALUES ('P');
INSERT INTO orders VALUES ('S');
INSERT INTO orders VALUES ('D');
INSERT INTO orders VALUES ('C');

SELECT decode(lower(status), 'p' , 'pending' , 's' , 'shipped' , 'd' , 'delivered' , 'cancelled' )
FROM orders; 