--TP 28 Exercices
CREATE TABLE pers(nom Text, prenom Text);

CREATE TABLE noms(nno Serial, nom Text,
CONSTRAINT pk_noms PRIMARY KEY(nno));

CREATE TABLE prenoms(pno Serial, prenom Text,
CONSTRAINT pk_prenoms PRIMARY KEY(pno));

CREATE TABLE asso(nno INT, pno INT);

INSERT INTO pers VALUES('Dupont','Pierre');
INSERT INTO pers VALUES('Dupont','Martin');
INSERT INTO pers VALUES('Dupont','Isabelle');
INSERT INTO pers VALUES('Durand','Pierre');
INSERT INTO pers VALUES('Lefebvre',NULL);
INSERT INTO pers VALUES('Lefebvre',NULL);
INSERT INTO pers VALUES(NULL,'Isabelle');

INSERT INTO noms(nom) SELECT nom FROM pers;
INSERT INTO prenoms(prenom) SELECT prenom FROM pers;

INSERT INTO asso(nno, pno) SELECT nno, pno FROM noms AS N inner join prenoms AS P ON N.nno=P.pno;

SELECT * FROM pers;
SELECT * FROM noms;
SELECT * FROM prenoms;
SELECT * FROM asso;

CREATE VIEW result
AS SELECT nom, prenom FROM noms  AS N inner join prenoms AS P ON N.nno=P.pno;

SELECT * FROM result;
