                --Partie 1
--1
--Calcul du nombre de filles (c'est pour la science)
SELECT SUM(CAST(n77 AS NUMERIC)) AS NombreFilleScientifique
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE filiere_formation LIKE '%scien%' AND (E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire');
--X
-- nombrefillescientifique 
---------------------------
--               1325188.0

--calcul inverse
SELECT SUM(CAST(n77 AS NUMERIC)) AS NombreFilleDepartement
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire';
--Y
-- nombrefilledepartement 
--------------------------
--             45230497.0

--(1325188.0/45230497.0)=0.029

--2
--n58=techbac n57=genbac
--Calcul BacTechSelect
SELECT Sum(n58) AS BacTechSelect
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE F.selectivite='formation sélective' AND (E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire');
--A
-- bactechselect 
-----------------
--        851736

--Calcul BacTechTotal
SELECT Sum(n58) AS BacTechTotal
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire';
--B
-- bactechtotal 
------------------
--        3669482

--P1=(851736/3669482)=0.232

--Calcul BacGenSelect
SELECT Sum(n57) AS BacGenSelect
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE F.selectivite='formation sélective' AND (E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire');
--C
-- bacgenselect 
----------------
--      8206659

SELECT Sum(n57) AS BacGenTotal
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire';
--D
-- bacgentotal 
----------------
--      41845802

--P2=(8206659/41845802)*100=0.196

--Si p1>p2 alors bactechno ont de la chance sinon le contraire.

--3
--n24=bourse gen n26=bourse tech n28=bourse pro
SELECT CONCAT(Sum(n24)+Sum(n26)+Sum(n28)) AS TotalBoursiers
FROM stats AS S INNER JOIN etablissements AS E ON S.eno=E.eno
WHERE E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire';
--A
-- totalboursiers 
------------------
-- 2049550

--boursier étude > 0 < 2 BTS & DUT
SELECT CONCAT(Sum(n24)+Sum(n26)+Sum(n28)) AS CoursEtudeBoursiers
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE (filiere_formation LIKE '%BTS%' OR filiere_formation LIKE '%DUT%') AND (E.region_etablissement='Pays de la Loire' OR E.region_etablissement='Centre-Val de Loire');
--B
-- coursetudeboursiers 
---------------------
-- 960290

--P=(960290/2049550)=0.468

                    --Partie 2   I.U.T. Nantes et I.U.T d'Orléans
    -- I.U.T. Nantes
--Total Candidats
SELECT CONCAT(SUM(CAST(n74 AS NUMERIC))+Sum(CAST(n75 AS NUMERIC))+Sum(CAST(n76 AS NUMERIC))) AS CandidatTotalDepartement
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.nom='I.U.T. Nantes' AND filiere_formation LIKE '%BUT%Informatique%';
--A
-- candidattotaldepartement 
----------------------------
-- 20016.0

--Calcul du nombre de filles (c'est pour le dev)
SELECT SUM(CAST(n77 AS NUMERIC)) AS BUTInfoFille
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.nom='I.U.T. Nantes' AND filiere_formation LIKE '%BUT%Informatique%';
 --B
-- butinfofille 
----------------
--       1080.0

--PNantes=(1080.0/20016.0)=0.053

    -- I.U.T d'Orléans
--Total Candidats
SELECT CONCAT(SUM(CAST(n74 AS NUMERIC))+Sum(CAST(n75 AS NUMERIC))+Sum(CAST(n76 AS NUMERIC))) AS CandidatTotalDepartement
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.nom='I.U.T d''Orléans' AND filiere_formation LIKE '%BUT%Informatique%';
--A
-- candidattotaldepartement 
----------------------------
-- 14760.0

--Calcul du nombre de filles (c'est pour le dev)
SELECT SUM(CAST(n77 AS NUMERIC)) AS BUTInfoFille
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE E.nom='I.U.T d''Orléans' AND filiere_formation LIKE '%BUT%Informatique%';
 --B
-- butinfofille 
----------------
--    1616.0

--POrléans=(1616.0/14760.0)=0.109

    -- I.U.T. Nantes
--n85 n86 n87 n88 <-Ont la mention et sont admis
SELECT CONCAT((Sum(CAST(n85 AS NUMERIC))+Sum(CAST(n86 AS NUMERIC))+Sum(CAST(n87 AS NUMERIC))+Sum(CAST(n88 AS NUMERIC)))) AS NombresAdmisAvecMentionAuBac
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE filiere_formation LIKE '%BUT%Informatique%' AND E.nom='I.U.T. Nantes';
--C
-- nombresadmisavecmentionaubac 
--------------------------------
-- 6561.0

--PNantesMention=(6561.0/20016.0)=0.3278


    -- I.U.T d'Orléans
--n85 n86 n87 n88 <-Ont la mention et sont admis
SELECT CONCAT((Sum(CAST(n85 AS NUMERIC))+Sum(CAST(n86 AS NUMERIC))+Sum(CAST(n87 AS NUMERIC))+Sum(CAST(n88 AS NUMERIC)))) AS NombresAdmisAvecMentionAuBac
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE filiere_formation LIKE '%BUT%Informatique%' AND E.nom='I.U.T d''Orléans';
--C
-- nombresadmisavecmentionaubac 
--------------------------------
-- 5256.0

--POrléansMention=(5256.0/14760.0)=0.356

        -- I.U.T. Nantes
--n25 n23 n27 n29
SELECT CONCAT((Sum(n25)+Sum(n23)+Sum(n27)+Sum(n29))) AS TauxdeBTNetGetOther
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE filiere_formation LIKE '%BUT%Informatique%' AND E.nom='I.U.T. Nantes';
--D
-- tauxdebtnetgetother 
-----------------------
-- 100890

--PNantesTaux=(20016.0/100890)=0.198

    -- I.U.T d'Orléans
--n25 n23 n27 n29
SELECT CONCAT((Sum(n25)+Sum(n23)+Sum(n27)+Sum(n29))) AS TauxdeBTNetGetOther
FROM formations AS F INNER JOIN stats AS S ON F.eno=S.eno INNER JOIN etablissements AS E ON F.eno=E.eno
WHERE filiere_formation LIKE '%BUT%Informatique%' AND E.nom='I.U.T d''Orléans';
--D
-- tauxdebtnetgetother 
-----------------------
-- 67976

--POrléansTaux=(14760.0/67976)=0.217