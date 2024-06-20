package org.example.banque;

public abstract class CompteBancaire {
    protected double solde;
    protected String client;

    public abstract BanqueEnum.TypeCompte getTypeCompte();

    public Double getSolde() {
        return solde;
    }

    public String getClient() {
        return client;
    }

    public void effectuerRetrait(double montant) {
        this.solde -= montant;
    }

    public void effectuerDepot(double montant) {
        this.solde += montant;
    }
}

/*
Attention, pour compte bancaire, la création devrait faire une opération de dépôt initial
Pour aller plus loin, ce qu'on propose en général c'est que CompteEpargne ai un taux d'intérets
et une méthode pour appliquer les intérets (nouvelle opération de dépôt)
et que ComptePayant ai un coût d'opération qui est appliqué en temps que nouvelle opération à chaque dépôt ou retrait
* */

