DROP TABLE message IF EXISTS;

CREATE TABLE message (
  name VARCHAR(20) NOT NULL,
  PRIMARY KEY(name)
);

INSERT INTO message VALUES('Dilbert');
INSERT INTO message VALUES('Dogbert');
INSERT INTO message VALUES('Catbert');
