package org.example.banque;

public class CompteCourant extends CompteBancaire {

    public CompteCourant(double solde, String identifiantC) {
        super(solde, identifiantC);
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_COURANT;
    }
}
