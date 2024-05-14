--Exercice 1
CREATE TABLE import (n1 text NULL, n2 CHAR(40), n3 CHAR(10), n4 CHAR(138), n5 CHAR(4) NULL, n6 CHAR(25), 
  n7 CHAR(29), n8 CHAR(21), n9 CHAR(31), n10 text, n11  CHAR(25), n12  CHAR(20), 
  n13 text, n14  CHAR(68), n15 text, n16  CHAR(167), n17  CHAR(23), n18  INT NULL, 
  n19  INT NULL, n20  INT NULL, n21  INT NULL, n22  text NULL, n23  INT NULL, n24  INT NULL, n25  INT NULL, 
  n26  INT NULL, n27  INT NULL, n28  INT NULL, n29  INT NULL, n30  INT NULL, n31  INT NULL, n32  INT NULL, 
  n33  INT NULL, n34  INT NULL, n35  INT NULL, n36  INT NULL, n37  text NULL, n38  text NULL, n39  INT NULL, 
  n40  INT NULL, n41  INT NULL, n42  INT NULL, n43  INT NULL, n44  INT NULL, n45  INT NULL, n46  INT NULL, 
  n47  INT NULL, n48  INT NULL, n49  INT, n50  INT, n51  CHAR(8), n52  CHAR(8), n53  CHAR(8), 
  n54  text NULL, n55  INT, n56  INT, n57  INT NULL, n58  INT NULL, n59  INT NULL, n60  INT NULL, 
  n61  INT NULL, n62  INT NULL, n63  INT NULL, n64  INT NULL, n65  INT NULL, n66  CHAR(7), n67  INT NULL, 
  n68  INT NULL, n69  INT NULL, n70  text NULL, n71  text NULL, n72  INT NULL, n73  INT NULL, n74  CHAR(7), 
  n75  CHAR(7), n76  CHAR(7), n77  CHAR(7), n78  CHAR(7), n79  CHAR(7), n80  CHAR(7), n81  CHAR(7), 
  n82  CHAR(7), n83  CHAR(6), n84  CHAR(7), n85  CHAR(7), n86  CHAR(7), n87  CHAR(7), n88  CHAR(7), 
  n89  CHAR(7), n90  CHAR(7), n91  CHAR(7), n92  CHAR(7), n93  CHAR(7), n94  CHAR(7), n95  CHAR(7), 
  n96  CHAR(7), n97  CHAR(7), n98  CHAR(7), n99  CHAR(7), n100 CHAR(7), n101 CHAR(7), n102 CHAR(41), 
  n103 CHAR(9), n104 text NULL, n105 text NULL, n106 CHAR(41), n107 text NULL, n108 CHAR(47), n109 CHAR(21), 
  n110 INT NULL, n111 CHAR(102), n112 CHAR(112), n113 CHAR(7), n114 CHAR(7), n115 CHAR(7), n116 CHAR(7), 
  n117 CHAR(7), n118 CHAR(7));

--Commande de copie
\copy import FROM 'fr-esr-parcoursup.csv' WITH (FORMAT csv, DELIMITER ';', HEADER true);

--Exercice 2
--Table etablissements : gère les établissements
CREATE TABLE etablissements(
    eno CHAR(10), -- Is Primary Key (n3)
    nom CHAR(138), -- n4
    code_departemental CHAR(4), --n5
    nom_departement CHAR(25), --n6
    region_etablissement CHAR(29), --n7
    academie_etablissement CHAR(21), --n8
    commune_etablissement CHAR(31), --n9
    coordonnee_gps CHAR(23), --n17
    capacite_etablissement_formation INTEGER --n18
    --CONSTRAINT pk_eno  (eno)
);

--Table formations : gère l'ensemble des données par rapport au formations.
CREATE TABLE formations(
    eno CHAR(10),-- Is Foreign Key 
    session text NULL, --n1
    filiere_formation text, --n10
    selectivite CHAR(25), --n11
    filiere_formation_short CHAR(20), --n12
    filiere_formation_long text --n13
);

--Table contracts : gère les contracts et regroupe la table etablissements et formations
CREATE TABLE contracts(
    eno CHAR(10), -- Is Foreign Key 
    statue CHAR(40) --n2
);

--Table stats : gère toute les stats (va servir pour la partie stats de la Saé)
CREATE TABLE stats(
    eno CHAR(10), -- Is Foreign Key
    n18  INT NULL, 
    n19  INT NULL, n20  INT NULL, n21  INT NULL, n22  text NULL, n23  INT NULL, n24  INT NULL, n25  INT NULL, 
    n26  INT NULL, n27  INT NULL, n28  INT NULL, n29  INT NULL, n30  INT NULL, n31  INT NULL, n32  INT NULL, 
    n33  INT NULL, n34  INT NULL, n35  INT NULL, n36  INT NULL, n37  text NULL, n38  text NULL, n39  INT NULL, 
    n40  INT NULL, n41  INT NULL, n42  INT NULL, n43  INT NULL, n44  INT NULL, n45  INT NULL, n46  INT NULL, 
    n47  INT NULL, n48  INT NULL, n49  INT, n50  INT, n51  CHAR(8), n52  CHAR(8), n53  CHAR(8), 
    n54  text NULL, n55  INT, n56  INT, n57  INT NULL, n58  INT NULL, n59  INT NULL, n60  INT NULL, 
    n61  INT NULL, n62  INT NULL, n63  INT NULL, n64  INT NULL, n65  INT NULL, n66  CHAR(7), n67  INT NULL, 
    n68  INT NULL, n69  INT NULL, n70  text NULL, n71  text NULL, n72  INT NULL, n73  INT NULL, n74  CHAR(7), 
    n75  CHAR(7), n76  CHAR(7), n77  CHAR(7), n78  CHAR(7), n79  CHAR(7), n80  CHAR(7), n81  CHAR(7), 
    n82  CHAR(7), n83  CHAR(6), n84  CHAR(7), n85  CHAR(7), n86  CHAR(7), n87  CHAR(7), n88  CHAR(7), 
    n89  CHAR(7), n90  CHAR(7), n91  CHAR(7), n92  CHAR(7), n93  CHAR(7), n94  CHAR(7), n95  CHAR(7), 
    n96  CHAR(7), n97  CHAR(7), n98  CHAR(7), n99  CHAR(7), n100 CHAR(7), n101 CHAR(7), n102 CHAR(41), 
    n103 CHAR(9), n104 text NULL, n105 text NULL, n106 CHAR(41), n107 text NULL, n108 CHAR(47), n109 CHAR(21), 
    n110 INT NULL, n111 CHAR(102), n112 CHAR(112), n113 CHAR(7), n114 CHAR(7), n115 CHAR(7), n116 CHAR(7), 
    n117 CHAR(7), n118 CHAR(7)
);

-- Les différents inserts
INSERT INTO etablissements(eno, nom, code_departemental, nom_departement, region_etablissement, academie_etablissement, commune_etablissement, coordonnee_gps, capacite_etablissement_formation)
SELECT n3, n4, n5, n6, n7, n8, n9, n17, n18
FROM import;

INSERT INTO formations(eno, session, filiere_formation, selectivite, filiere_formation_short, filiere_formation_long)
SELECT n3, n1, n10, n11, n12, n13
FROM import;

INSERT INTO contracts(eno, statue)
SELECT n3, n2
FROM import;

--celui-ci est très long étant donné qu'il va me servir pour la partie stats
INSERT INTO stats(eno, 
    n18, 
    n19, n20, n21, n22, n23, n24, n25, 
    n26, n27, n28, n29, n30, n31, n32, 
    n33, n34, n35, n36, n37, n38, n39, 
    n40, n41, n42, n43, n44, n45, n46, 
    n47, n48, n49, n50, n51, n52, n53, 
    n54, n55, 
    n56, n57, n58, n59, n60, n61, n62, n63, n64, n65, n66, n67, n68, n69, n70, n71, n72, n73, n74, 
    n75, n76, n77, n78, n79, n80, n81, 
    n82, n83, n84, n85, n86, n87, n88, 
    n89, n90, n91, n92, n93, n94, n95, 
    n96, n97, n98, n99, n100, n101, n102, 
    n103, n104, n105, n106, n107, n108, n109, 
    n110, n111, n112, n113, n114, n115, n116, 
    n117, n118)
SELECT n3, 
    n18, 
    n19, n20, n21, n22, n23, n24, n25, 
    n26, n27, n28, n29, n30, n31, n32, 
    n33, n34, n35, n36, n37, n38, n39, 
    n40, n41, n42, n43, n44, n45, n46, 
    n47, n48, n49, n50, n51, n52, n53, 
    n54, n55, 
    n56, n57, n58, n59, n60, n61, n62, n63, n64, n65, n66, n67, n68, n69, n70, n71, n72, n73, n74, 
    n75, n76, n77, n78, n79, n80, n81, 
    n82, n83, n84, n85, n86, n87, n88, 
    n89, n90, n91, n92, n93, n94, n95, 
    n96, n97, n98, n99, n100, n101, n102, 
    n103, n104, n105, n106, n107, n108, n109, 
    n110, n111, n112, n113, n114, n115, n116, 
    n117, n118
FROM import;
--END
