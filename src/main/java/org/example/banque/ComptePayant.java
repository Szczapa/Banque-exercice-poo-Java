package org.example.banque;

public class ComptePayant extends CompteBancaire {

    private final double coutOperation;

    public ComptePayant(Double solde, String identifiantC, double coutOperation, String accountId) {
        super(solde, identifiantC, accountId);
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
