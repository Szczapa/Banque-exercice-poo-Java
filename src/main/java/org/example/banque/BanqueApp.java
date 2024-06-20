package org.example.banque;

import java.util.Scanner;

public class BanqueApp {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        while (true) {
            BanqueAppMenu.mainMenu();
            try {
                int uniteChoix = Integer.parseInt(scanner.nextLine());
                if (uniteChoix < 0) {
                    throw new IllegalArgumentException("Veuillez entrer un nombre positif");
                }
                switch (uniteChoix) {
                    case 1:
                        listerComptes(client);
                        continue;
                    case 2:
                        creerCompte(client);
                        continue;
                    case 3:
                        effectuerDepot(client);
                        continue;
                    case 4:
                        effectuerRetrait(client);
                        continue;
                    case 5:
                        afficherOperationsEtSolde(client);
                        continue;
                    case 0:
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        scanner.close();
    }


    private void effectuerDepot(Client client) {
        Scanner scanner = new Scanner(System.in);
        boolean effectuerDepot = false;
        int choix = 0;
        double montant = 0;
        do {
            listerComptes(client);
            BanqueAppMenu.typeCompteMenu();
            try {
                choix = Integer.parseInt(scanner.nextLine());
                if (choix >= 1 && choix <= 3) {
                    BanqueEnum.TypeCompte typeCompte = switch (choix) {
                        case 1 -> BanqueEnum.TypeCompte.COMPTE_PAYANT;
                        case 2 -> BanqueEnum.TypeCompte.COMPTE_EPARGNE;
                        case 3 -> BanqueEnum.TypeCompte.COMPTE_COURANT;
                        default -> throw new IllegalStateException("Unexpected value: " + choix);
                    };
                    boolean notExist = client.checkAccount(typeCompte);
                    if (!notExist) {
                        System.out.println("Erreur: Ce type de compte n'existe pas.");
                        continue;
                    }
                    System.out.println("Veuillez entrer le montant du dépôt: ");
                    montant = Double.parseDouble(scanner.nextLine());
                    if (montant <= 0) {
                        throw new IllegalArgumentException("Montant invalide");
                    }
                    effectuerDepot = client.effectuerDepot(typeCompte, montant);
                } else if (choix != 0) {
                    System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!effectuerDepot && choix != 0);

        if (effectuerDepot) {
            System.out.println("Dépôt effectué avec succès. Montant :" + montant + " €");
        } else {
            System.out.println("Annulation dépot.");
        }
    }

    private void effectuerRetrait(Client client) {
        Scanner scanner = new Scanner(System.in);
        boolean effectuerRetrait = false;
        int choix = 0;
        double montant = 0;
        do {
            listerComptes(client);
            BanqueAppMenu.typeCompteMenu();
            try {
                choix = Integer.parseInt(scanner.nextLine());
                if (choix >= 1 && choix <= 3) {
                    BanqueEnum.TypeCompte typeCompte = switch (choix) {
                        case 1 -> BanqueEnum.TypeCompte.COMPTE_PAYANT;
                        case 2 -> BanqueEnum.TypeCompte.COMPTE_EPARGNE;
                        case 3 -> BanqueEnum.TypeCompte.COMPTE_COURANT;
                        default -> throw new IllegalStateException("Unexpected value: " + choix);
                    };
                    boolean notExist = client.checkAccount(typeCompte);
                    if (!notExist) {
                        System.out.println("Erreur: Ce type de compte n'existe pas.");
                        continue;
                    }
                    System.out.println("Veuillez entrer le montant du dépôt: ");
                    montant = Double.parseDouble(scanner.nextLine());
                    if (montant <= 0) {
                        throw new IllegalArgumentException("Montant invalide");
                    }
                    effectuerRetrait = client.effectuerRetrait(typeCompte, montant);
                } else if (choix != 0) {
                    System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!effectuerRetrait && choix != 0);
        if (effectuerRetrait) {
            System.out.println("Retrait effectué avec succès. Montant : -" + montant + " €");
        } else {
            System.out.println("Annulation retrait.");
        }
    }

    private void creerCompte(Client client) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        boolean compteCree;
        do {
            listerComptes(client);
            BanqueAppMenu.compteMenu();
            compteCree = false;
            try {
                choix = Integer.parseInt(scanner.nextLine());
                if (choix < 0) {
                    throw new IllegalArgumentException("Veuillez entrer un nombre positif");
                }
                switch (choix) {
                    case 3:
                        compteCree = client.CreateAccount(BanqueEnum.TypeCompte.COMPTE_COURANT, 0, client.getIdentifiant(), 0);
                        break;
                    case 2:
                        compteCree = client.CreateAccount(BanqueEnum.TypeCompte.COMPTE_EPARGNE, 0, client.getIdentifiant(), 0);
                        break;
                    case 1:
                        compteCree = client.CreateAccount(BanqueEnum.TypeCompte.COMPTE_PAYANT, 0, client.getIdentifiant(), 0);
                        break;
                    case 0:
                        System.out.println("Retour au menu principal.");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (choix != 0 && !compteCree);
    }

    private void listerComptes(Client client) {
        System.out.println(" ");
        System.out.println("Liste des comptes de " + client.getNom() + " " + client.getPrenom()+":");
        client.getComptes().forEach(compte -> {
            System.out.println(" ");
            System.out.println("Type de compte: " + compte.getTypeCompte());
            System.out.println("Solde: " + compte.getSolde());
//            System.out.println("Identifiant client: " + compte.getClient());
        });
    }

    private void afficherOperationsEtSolde(Client client) {
        System.out.println("Liste des opérations de " + client.getNom() + " " + client.getPrenom());
        client.afficherOperationsEtSolde();
    }
}
