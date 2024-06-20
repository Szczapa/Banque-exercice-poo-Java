package org.example.banque;

public class ComptePayant extends CompteBancaire {

    private double coutOperation;

    public ComptePayant(Double solde, String identifiantC, double coutOperation) {
        super(solde, identifiantC);
        this.coutOperation = coutOperation;
    }

    @Override
    public void effectuerDepot(double montant) {
        super.effectuerDepot(montant - coutOperation * montant);
    }

    @Override
    public void effectuerRetrait(double montant) {
        super.effectuerRetrait(montant + coutOperation * montant);
    }

    @Override
    public BanqueEnum.TypeCompte getTypeCompte() {
        return BanqueEnum.TypeCompte.COMPTE_PAYANT;
    }
}
