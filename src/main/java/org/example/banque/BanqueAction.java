package org.example.banque;

public class BanqueAction {
    private BanqueEnum.TypeCompte typeCompte;
    private double montant;
    private double solde;
    private BanqueEnum.TypeOperation actionType;


    public BanqueAction(BanqueEnum.TypeCompte typeCompte, double montant, BanqueEnum.TypeOperation actionType, double solde) {
        this.typeCompte = typeCompte;
        this.montant = montant;
        this.actionType = actionType;
        this.solde = solde;
    }

    public BanqueEnum.TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(BanqueEnum.TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public BanqueEnum.TypeOperation getActionType() {
        return actionType;
    }

    public void setActionType(BanqueEnum.TypeOperation actionType) {
        this.actionType = actionType;
    }


}
