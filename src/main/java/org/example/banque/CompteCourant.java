package org.example.banque;

public class CompteCourant extends CompteBancaire {

    public CompteCourant(double solde, String identifiantC) {
        this.solde = solde;
        this.client = identifiantC;
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_COURANT;
    }
}
