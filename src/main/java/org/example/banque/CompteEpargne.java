package org.example.banque;

public class CompteEpargne extends CompteBancaire {

    private double tauxInteret;

    public CompteEpargne(double solde, String identifiantC, double tauxInteret) {
        super(solde, identifiantC);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void effectuerDepot(double montant) {
        super.effectuerDepot(montant + tauxInteret * montant);
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_EPARGNE;
    }
}
