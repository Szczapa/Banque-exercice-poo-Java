package org.example.banque;

public class BanqueAppMenu {
    public static void mainMenu() {
        String menu = "\n=== Main Menu ===\n"
                + "1. Lister les comptes\n"
                + "2. Créer un compte\n"
                + "3. Effectuer un dépôt\n"
                + "4. Effectuer un retrait\n"
                + "5. Afficher les opérations et le solde\n"
                + "0. Quitter";
        System.out.println(menu);
    }

    public static void compteMenu() {
        String menu = "\n=== Création de compte ===\n"
                + "1. Compte payant\n"
                + "2. Compte épargne\n"
                + "3. Compte courant\n"
                + "0. Retour";
        System.out.println(menu);
    }

    public static void typeCompteMenu() {
        String menu = "\n=== Type de compte ===\n"
                + "1. Compte payant\n"
                + "2. Compte épargne\n"
                + "3. Compte courant\n"
                + "0. Retour";
        System.out.println(menu);
    }
}
