package org.example.banque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client {
    private static final BanqueEnum.TypeOperation DEPOT = BanqueEnum.TypeOperation.DEPOT;
    private static final BanqueEnum.TypeOperation RETRAIT = BanqueEnum.TypeOperation.RETRAIT;
    private final List<BanqueAction> actions;
    private String nom;
    private String prenom;
    private String identifiant;
    private List<CompteBancaire> comptes;

    public Client() {
        this.nom = "Dupont";
        this.prenom = "Jean";
        this.identifiant = "fnx145";
        this.comptes = new ArrayList<>();
        this.comptes.add(new CompteCourant(1300.50, "fnx145", "f1dx15z3"));
        this.actions = new ArrayList<>();
        this.actions.add(new BanqueAction(BanqueEnum.TypeCompte.COMPTE_COURANT, 1300.50, DEPOT, 1300.50));
    }

    public boolean CreateAccountCourant(BanqueEnum.TypeCompte typeCompte, double montant, String identifiantC, double solde, String accountId) {
        if (checkAccount(typeCompte)) {
            System.out.println("Erreur: Ce type de compte existe déjà.");
            return false;
        }
        comptes.add(new CompteCourant(solde, identifiantC, accountId));
        actions.add(new BanqueAction(BanqueEnum.TypeCompte.COMPTE_COURANT, montant, DEPOT, solde));
        System.out.println("Compte courant créé avec succès.");
        return true;
    }

    public boolean CreateAccountEpargne(BanqueEnum.TypeCompte typeCompte, double montant, String identifiantC, double solde, double tauxInteret, String accountId) {
        if (checkAccount(typeCompte)) {
            System.out.println("Erreur: Ce type de compte existe déjà.");
            return false;
        }

        comptes.add(new CompteEpargne(solde, identifiantC, tauxInteret, accountId));
        actions.add(new BanqueAction(BanqueEnum.TypeCompte.COMPTE_EPARGNE, montant, DEPOT, solde));
        System.out.println("Compte épargne créé avec succès.");

        return true;
    }

    public boolean CreateAccountPayant(BanqueEnum.TypeCompte typeCompte, double montant, String identifiantC, double solde, double tauxInteret, String accountId) {
        if (checkAccount(typeCompte)) {
            System.out.println("Erreur: Ce type de compte existe déjà.");
            return false;
        }

        comptes.add(new ComptePayant(solde, identifiantC, tauxInteret, accountId));
        actions.add(new BanqueAction(BanqueEnum.TypeCompte.COMPTE_PAYANT, montant, DEPOT, solde));
        System.out.println("Compte payant créé avec succès.");

        return true;
    }

    public boolean effectuerDepot(BanqueEnum.TypeCompte typeCompte, double montant) {
        for (CompteBancaire compte : comptes) {
            if (compte.getTypeCompte() == typeCompte) {
                compte.effectuerDepot(montant);
                actions.add(new BanqueAction(typeCompte, montant, DEPOT, compte.getSolde()));
                return true;
            }
        }
        System.out.println("Erreur: Ce type de compte n'existe pas.");
        return false;
    }


    public boolean effectuerRetrait(BanqueEnum.TypeCompte typeCompte, double montant) {
        for (CompteBancaire compte : comptes) {
            if (compte.getTypeCompte() == typeCompte) {
                compte.effectuerRetrait(montant);
                actions.add(new BanqueAction(typeCompte, montant, RETRAIT, compte.getSolde()));
                return true;
            }
        }
        System.out.println("Erreur: Ce type de compte n'existe pas.");
        return false;
    }

    public boolean checkAccount(BanqueEnum.TypeCompte typeCompte) {
        for (CompteBancaire compte : comptes) {
            if (compte.getTypeCompte() == typeCompte) {
                return true;
            }
        }
        return false;
    }

    public void afficherOperationsEtSolde() {
        List<BanqueAction> sortedActions = new ArrayList<>(actions);
        sortedActions.sort(Comparator.comparing(a -> a.getTypeCompte().toString()));

        for (BanqueAction action : sortedActions) {
            System.out.println(" ");
            System.out.println("Type de compte: " + action.getTypeCompte());
            System.out.println("Montant: " + action.getMontant());
            System.out.println("Type d'opération: " + action.getActionType());
            System.out.println("Solde: " + action.getSolde());
        }
    }

    public boolean checkIdExistance(String id) {
        for (CompteBancaire compte : comptes) {
            if (compte.getAccountId().equals(id)) {
                return true;
            }
        }
        return false;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }
}