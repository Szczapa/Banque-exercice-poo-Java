package org.example.banque;

public abstract class CompteBancaire {
    protected double solde;
    protected String client;

    public abstract BanqueEnum.TypeCompte getTypeCompte();

    public CompteBancaire(Double solde, String identifiantC) {
        this.solde = solde;
        this.client = identifiantC;
    }

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