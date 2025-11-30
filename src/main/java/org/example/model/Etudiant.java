package org.example.model;

public class Etudiant {
    private int id;
    private String nom;
    private String email;
    private int age;
    public Etudiant() {}
    public  Etudiant(String nom,String email,int age){
    this.nom=nom;
    this.email=email;
    this.age=age;
}
    public Etudiant(int id, String nom, String email, int age) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.age = age;
    }
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
