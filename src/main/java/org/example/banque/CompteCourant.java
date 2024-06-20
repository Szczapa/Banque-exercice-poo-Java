package org.example.banque;

public class CompteCourant extends CompteBancaire {

    public CompteCourant(double solde, String identifiantC, String accountId) {
        super(solde, identifiantC, accountId);
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_COURANT;
    }
}
