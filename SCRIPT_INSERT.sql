INSERT INTO categorie (idcategorie, nomcategorie) VALUES (1, 'gateau');
INSERT INTO categorie (idcategorie, nomcategorie) VALUES (2, 'dessert');
INSERT INTO categorie (idcategorie, nomcategorie) VALUES (3, 'boisson');
INSERT INTO categorie (idcategorie, nomcategorie) VALUES (4, 'aliments');
INSERT INTO categorie (idcategorie, nomcategorie) VALUES (5, 'entree');
INSERT INTO categorie (idcategorie, nomcategorie) VALUES (6, 'confiserie');



INSERT INTO composant (idcomposant, nomcomposant) VALUES (1, 'fromage');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (2, 'lait');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (3, 'farine');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (4, 'sucre');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (5, 'legume');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (6, 'tomate');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (7, 'persil');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (8, 'viande de poulet');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (9, 'riz');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (10, 'mortadelle');
INSERT INTO composant (idcomposant, nomcomposant) VALUES (11, 'pomme de terre');




INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 1, 20);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 2, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 3, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 4, 5);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (4, 8, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (4, 11, 20);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (3, 2, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (3, 4, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (2, 2, 10);



INSERT INTO produit (idproduit, idcategorie, nomcategorie) VALUES (1, 1, 'cheese cake');
INSERT INTO produit (idproduit, idcategorie, nomcategorie) VALUES (2, 3, 'lait');
INSERT INTO produit (idproduit, idcategorie, nomcategorie) VALUES (3, 3, 'milk shake');
INSERT INTO produit (idproduit, idcategorie, nomcategorie) VALUES (4, 4, 'poulet frite');



INSERT INTO utilisateur (idutilisateur, nom, prenom, datenaissance, sexe, adresse, email) VALUES (1, 'Rakotomananjo', 'Antsa', '2017-01-14', 'M', 'LOT 2T25 Iavoloha', 'antsuyu@gmail.com');
