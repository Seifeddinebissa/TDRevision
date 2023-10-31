package entities;

public abstract class Etudiant {
    protected int identifiant;
    protected String nom;
    protected String prenom;
    protected float moyenne;


    public Etudiant(){}
    public Etudiant(int identifiant, String nom, String prenom, float moyenne){
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }


    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
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

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public boolean equals(Object obj) {
        return this.identifiant == ((Etudiant)obj).getIdentifiant() && this.nom.equals(((Etudiant) obj).getNom());
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }

    public abstract void ajouterUneAbsence();
}
