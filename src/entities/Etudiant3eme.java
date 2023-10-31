package entities;

public class Etudiant3eme extends Etudiant{
    private String branche;

    public Etudiant3eme(){}
    public Etudiant3eme(int identifiant, String nom, String prenom, float moyenne, String branche){
        super(identifiant, nom, prenom, moyenne);
        this.branche = branche;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    @Override
    public void ajouterUneAbsence() {
        this.moyenne -= 0.5;
    }
}
