package org.example.banque;

public class CompteEpargne extends CompteBancaire {

    private static final double TAUX_INTERET = 0.05;

    public CompteEpargne(double solde, String identifiantC, double tauxInteret) {
        super(solde, identifiantC);
    }

    @Override
    public void effectuerDepot(double montant) {
        super.effectuerDepot(montant + TAUX_INTERET * montant);
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_EPARGNE;
    }
}
