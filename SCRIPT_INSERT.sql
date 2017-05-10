INSERT INTO categorie (nomcategorie) VALUES ('gateau');
INSERT INTO categorie (nomcategorie) VALUES ( 'dessert');
INSERT INTO categorie (nomcategorie) VALUES ( 'boisson');
INSERT INTO categorie (nomcategorie) VALUES ( 'aliments');
INSERT INTO categorie (nomcategorie) VALUES ( 'entree');
INSERT INTO categorie (nomcategorie) VALUES ( 'confiserie');



INSERT INTO composant (nomcomposant) VALUES ( 'fromage');
INSERT INTO composant (nomcomposant) VALUES ( 'lait');
INSERT INTO composant (nomcomposant) VALUES ( 'farine');
INSERT INTO composant (nomcomposant) VALUES ( 'sucre');
INSERT INTO composant (nomcomposant) VALUES ( 'legume');
INSERT INTO composant (nomcomposant) VALUES ( 'tomate');
INSERT INTO composant (nomcomposant) VALUES ( 'persil');
INSERT INTO composant (nomcomposant) VALUES ( 'viande de poulet');
INSERT INTO composant (nomcomposant) VALUES ('riz');
INSERT INTO composant (nomcomposant) VALUES ( 'mortadelle');
INSERT INTO composant (nomcomposant) VALUES ( 'pomme de terre');




INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 1, 20);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 2, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 3, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (1, 4, 5);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (4, 8, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (4, 11, 20);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (3, 2, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (3, 4, 10);
INSERT INTO composition (idproduit, idcomposant, quantite) VALUES (2, 2, 10);




INSERT INTO produit (idcategorie, nomproduit,idutilisateur) VALUES ( 1, 'cheese cake',1);
INSERT INTO produit (idcategorie, nomproduit,idutilisateur) VALUES ( 3, 'lait',1);
INSERT INTO produit (idcategorie, nomproduit,idutilisateur) VALUES ( 3, 'milk shake',1);
INSERT INTO produit (idcategorie, nomproduit,idutilisateur) VALUES ( 4, 'poulet frite',1);



INSERT INTO utilisateur (nomutilisateur, prenom, datenaissance, sexe, adresse, email) VALUES ( 'Rakotomananjo', 'Antsa', '2017-01-14', 'M', 'LOT 2T25 Iavoloha', 'antsuyu@gmail.com');
