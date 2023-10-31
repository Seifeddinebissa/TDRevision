package entities;

import Exceptions.EtudiantExisteException;

import java.util.Arrays;

public class Ecole {
    private String nom;
    private static final int CAPACITE_MAX=500;
    private Etudiant[] etudiants;
    private int nbrEtudiant;


    public Ecole(String nom){
        this.nom = nom;
        etudiants = new Etudiant[CAPACITE_MAX];
    }
    public Etudiant[] getEtudiants() {
        return etudiants;
    }
    public void setEtudiants(Etudiant[] etudiants) {
        this.etudiants = etudiants;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterEtudiant(Etudiant etudiant) throws EtudiantExisteException {
        if(nbrEtudiant == CAPACITE_MAX){
            System.out.println("L\'école est pleine");
        }else if(chercherEtudiant(etudiant) != -1){
            throw new EtudiantExisteException();
        }else{
            etudiants[nbrEtudiant] = etudiant;
            this.nbrEtudiant++;
            System.out.println("Etudiant ajoute avec succes");
        }
    }

    public int chercherEtudiant(Etudiant e){
        int index = -1;
        for (int i=0; i<nbrEtudiant; i++) {
            if(etudiants[i].equals(e)){
                index = i;
                //System.out.println(i);
            }
        }
        return index;
    }

    public int getNbrEtudiant() {
        return nbrEtudiant;
    }

    public void setNbrEtudiant(int nbrEtudiant) {
        this.nbrEtudiant = nbrEtudiant;
    }

    public float getMoyenneDes3A(){
        float somme = 0;
        int nbrEtu3A = 0;
        for (Etudiant e: etudiants) {
            if (e instanceof Etudiant3eme){
                somme += e.getMoyenne();
                nbrEtu3A++;
            }
        }
        return somme/nbrEtu3A;
    }

    public float moyenneSalaireAlternants(){
        int somme = 0;
        int nbrAlternant = 0;
        for (Etudiant e : etudiants) {
            if (e instanceof EtudiantAlternance){
                somme += ((EtudiantAlternance) e).getSalaire();
                nbrAlternant++;
            }
        }
        return somme/nbrAlternant;
    }

    @Override
    public String toString() {
        return "Ecole{" +
                "nom='" + nom + '\'' +
                ", etudiants=" + Arrays.toString(etudiants) +
                '}';
    }

    public void changerEcole(Etudiant etudiant, Ecole ecole){
        int index = this.chercherEtudiant(etudiant);
        if (index == -1){
            System.out.println("l'étudiant est n'exist pas");
        }else {
            try {
                for (int i = index; i < nbrEtudiant - 1; i++) {
                    etudiants[i] = etudiants[i+1];
                }
                nbrEtudiant--;
                ecole.ajouterEtudiant(etudiant);
                ecole.setNbrEtudiant(ecole.getNbrEtudiant()+1);
            }catch (EtudiantExisteException e) {
                e.getMessage();
            }
        }
    }
}
