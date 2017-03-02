/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     01/03/2017 11:13:19                          */
/*==============================================================*/


drop index CATEGORIE_PK;

drop table CATEGORIE;

drop index COMPOSANT_PK;

drop table COMPOSANT;

drop index COMPOSITION2_FK;

drop index COMPOSITION_FK;

drop index COMPOSITION_PK;

drop table COMPOSITION;

drop index ASSOCIATION_1_FK;

drop index PRODUIT_PK;

drop table PRODUIT;

drop index UTILISATEUR_PK;

drop table UTILISATEUR;

/*==============================================================*/
/* Table: CATEGORIE                                             */
/*==============================================================*/
create table CATEGORIE (
   IDCATEGORIE          SERIAL               not null,
   NOMCATEGORIE         VARCHAR(200)         null,
   constraint PK_CATEGORIE primary key (IDCATEGORIE)
);

/*==============================================================*/
/* Index: CATEGORIE_PK                                          */
/*==============================================================*/
create unique index CATEGORIE_PK on CATEGORIE (
IDCATEGORIE
);

/*==============================================================*/
/* Table: COMPOSANT                                             */
/*==============================================================*/
create table COMPOSANT (
   IDCOMPOSANT          SERIAL               not null,
   NOMCOMPOSANT         VARCHAR(200)         null,
   constraint PK_COMPOSANT primary key (IDCOMPOSANT)
);

/*==============================================================*/
/* Index: COMPOSANT_PK                                          */
/*==============================================================*/
create unique index COMPOSANT_PK on COMPOSANT (
IDCOMPOSANT
);

/*==============================================================*/
/* Table: COMPOSITION                                           */
/*==============================================================*/
create table COMPOSITION (
   IDPRODUIT            INT4                 not null,
   IDCOMPOSANT          INT4                 not null,
   QUANTITE             INT4                 null,
   constraint PK_COMPOSITION primary key (IDPRODUIT, IDCOMPOSANT)
);

/*==============================================================*/
/* Index: COMPOSITION_PK                                        */
/*==============================================================*/
create unique index COMPOSITION_PK on COMPOSITION (
IDPRODUIT,
IDCOMPOSANT
);

/*==============================================================*/
/* Index: COMPOSITION_FK                                        */
/*==============================================================*/
create  index COMPOSITION_FK on COMPOSITION (
IDPRODUIT
);

/*==============================================================*/
/* Index: COMPOSITION2_FK                                       */
/*==============================================================*/
create  index COMPOSITION2_FK on COMPOSITION (
IDCOMPOSANT
);

/*==============================================================*/
/* Table: PRODUIT                                               */
/*==============================================================*/
create table PRODUIT (
   IDPRODUIT            SERIAL               not null,
   IDCATEGORIE          INT4                 not null,
   NOMCATEGORIE         VARCHAR(200)         null,
   constraint PK_PRODUIT primary key (IDPRODUIT)
);

/*==============================================================*/
/* Index: PRODUIT_PK                                            */
/*==============================================================*/
create unique index PRODUIT_PK on PRODUIT (
IDPRODUIT
);

/*==============================================================*/
/* Index: ASSOCIATION_1_FK                                      */
/*==============================================================*/
create  index ASSOCIATION_1_FK on PRODUIT (
IDCATEGORIE
);

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
create table UTILISATEUR (
   IDUTILISATEUR        SERIAL               not null,
   NOMCATEGORIE         VARCHAR(200)         null,
   PRENOM               VARCHAR(100)         null,
   DATENAISSANCE        DATE                 null,
   SEXE                 VARCHAR(2)           null,
   ADRESSE              VARCHAR(200)         null,
   EMAIL                VARCHAR(200)         null,
   constraint PK_UTILISATEUR primary key (IDUTILISATEUR)
);

/*==============================================================*/
/* Index: UTILISATEUR_PK                                        */
/*==============================================================*/
create unique index UTILISATEUR_PK on UTILISATEUR (
IDUTILISATEUR
);

alter table COMPOSITION
   add constraint FK_COMPOSIT_COMPOSITI_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT)
      on delete restrict on update restrict;

alter table COMPOSITION
   add constraint FK_COMPOSIT_COMPOSITI_COMPOSAN foreign key (IDCOMPOSANT)
      references COMPOSANT (IDCOMPOSANT)
      on delete restrict on update restrict;

alter table PRODUIT
   add constraint FK_PRODUIT_ASSOCIATI_CATEGORI foreign key (IDCATEGORIE)
      references CATEGORIE (IDCATEGORIE)
      on delete restrict on update restrict;

