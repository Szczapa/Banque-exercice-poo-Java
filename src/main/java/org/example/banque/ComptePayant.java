package org.example.banque;

public class ComptePayant extends CompteBancaire {

    private static final double COUT_OPERATION = 0.05;

    public ComptePayant(Double solde, String identifiantC) {
        this.solde = solde;
        this.client = identifiantC;
    }

    @Override
    public void effectuerDepot(double montant) {
        super.effectuerDepot(montant - COUT_OPERATION * montant);
    }

    @Override
    public void effectuerRetrait(double montant) {
        super.effectuerRetrait(montant + COUT_OPERATION * montant);
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_PAYANT;
    }
}
