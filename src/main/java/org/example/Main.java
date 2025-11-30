package org.example;

import org.example.dao.DbConnection;
import org.example.dao.EtudiantDao;
import org.example.model.Etudiant;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EtudiantDao etudiantDao = new EtudiantDao();
        DbConnection dbConnection = new DbConnection();
        while (true){
            System.out.print("1. Ajouter Etudiant");
            System.out.print("2. Afficher la liste d'Etudiant");
            System.out.println("3. Modifier un Etudiant");
            System.out.println("4. Supprimer un Etudiant");
            System.out.println("5. Quitter");
            System.out.println("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix){
                case 1:
                    System.out.println("Id :");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nom : ");
                    String nom = sc.nextLine();
                    System.out.println("Email : ");
                    String email = sc.nextLine();
                    System.out.println("Age");
                    int age = sc.nextInt();
                    etudiantDao.addEtudiant(new Etudiant(id,nom,email,age));
                    break;

                case 2:
                    etudiantDao.getEtudiants().forEach(e-> System.out.println(e.getId() + "|" + e.getNom() + "|" + e.getEmail() + "|" + e.getAge()));
                    break;

                    case 3:
                        System.out.println("ID etudiant : ");
                        int id1 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nouveau nom : ");
                        String nom2 = sc.nextLine();
                        System.out.println("Nouveau email : ");
                        String email2 = sc.nextLine();
                        System.out.println("Nouveau age : ");
                        int age2 = sc.nextInt();
                        etudiantDao.updateEtudiant(new Etudiant(id1,nom2,email2,age2));
                        break;

                        case 4:
                            System.out.println("ID etudiant : ");
                            int id2 = sc.nextInt();
                            etudiantDao.deleteEtudiant(id2);
                            break;

                            case 5:
                                System.out.println("Au revoir");
                                dbConnection.closeConnection();
                               return;

            }




        }
    }
}