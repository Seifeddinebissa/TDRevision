package main;

import Exceptions.EtudiantExisteException;
import entities.Ecole;
import entities.Etudiant;
import entities.Etudiant3eme;
import entities.EtudiantAlternance;

public class test {
    public static void main(String[] args){
        Ecole esprit = new Ecole("esprit");
        Ecole tekUp = new Ecole("tek-up");
        Etudiant3eme etu31 = new Etudiant3eme(123,"seif","seif",16,"GL");
        Etudiant3eme etu32 = new Etudiant3eme(456,"hilmi","hilmi",15,"GL");
        EtudiantAlternance alter1 = new EtudiantAlternance(789,"nessim","nessim",17,1100);
        EtudiantAlternance alter2 = new EtudiantAlternance(123,"seif","mohamed",17,1000);

        try{
            esprit.ajouterEtudiant(etu31);
            esprit.ajouterEtudiant(etu32);
            esprit.ajouterEtudiant(alter1);
            esprit.ajouterEtudiant(alter2);
        }catch (EtudiantExisteException e){
            System.out.println(e.getMessage());

        }
        System.out.println(esprit.toString());
        System.out.println("----------------------------------------------------------------------");
        esprit.changerEcole(etu31, tekUp);
        System.out.println(esprit.toString());
        System.out.println("----------------------------------------------------------------------");
        System.out.println(tekUp.toString());
    }
}
