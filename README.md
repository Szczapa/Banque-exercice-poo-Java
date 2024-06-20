
# Banque Poo Exercice :

Permier Exercice de Poo avec système IHM dans console 

- [x]  Créer une classe abstraite CompteBancaire. Cette classe aura : un solde, un client et une liste d'opérations(dépôt ou retrait).

- [x]  Créer les classes : ComptePayant, CompteEpargne, CompteCourant qui héritent de CompteBancaire.

- [x]  Créer une classe Client avec les attributs suivants : nom, prénom, identifiant, liste des comptes et numéro de téléphone. On créera le client au début de l'application.

- [x] Créer une classe Opération avec les attributs suivants :
        numéro, montant et statut (depot/retrait en enum)

- [x]  Créer une IHM pour tester l'application. Pour un compte
        au choix de l'utilisateur on pourra effectuer un dépôt, un retrait ou afficher le solde et les opérations.



### Options Bonus : 

- [x] Attention, pour compte bancaire, la création devrait faire une opération de dépôt initial

- [x]  Pour aller plus loin, ce qu'on propose en général c'est que CompteEpargne ai un taux d'intérets et une méthode pour appliquer les intérets (nouvelle opération de dépôt) et que ComptePayant ai un coût d'opération qui est appliqué en temps que nouvelle opération à chaque dépôt ou retrait.

#### Todo : 

- [ ]  Systeme de selection d'utilisateur avec vérification de mot de passe & d'identifiant.
