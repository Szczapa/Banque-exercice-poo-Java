package org.example.banque;

public abstract class CompteBancaire {
    protected double solde;
    protected String client;
    protected String accountId;

    public CompteBancaire(Double solde, String identifiantC, String accountId) {
        this.solde = solde;
        this.client = identifiantC;
        this.accountId = accountId;
    }

    public abstract BanqueEnum.TypeCompte getTypeCompte();

    public Double getSolde() {
        return solde;
    }

    public String getClient() {
        return client;
    }

    public String getAccountId() { return accountId; }


    public void effectuerRetrait(double montant) {
        this.solde -= montant;
    }

    public void effectuerDepot(double montant) {
        this.solde += montant;
    }

}