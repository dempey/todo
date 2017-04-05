CREATE TABLE IF NOT EXISTS Todo(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(75));
DELETE FROM Todo;
INSERT INTO Todo VALUES(1, true, 'Prepare presentation');
INSERT INTO Todo VALUES(2, true, 'Procrastinate');
INSERT INTO Todo VALUES(3, false, 'Deliver presentation');
INSERT INTO Todo VALUES(4, false, 'Eat lunch');
INSERT INTO Todo VALUES(5, false, 'Take a nap');