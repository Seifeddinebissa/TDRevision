package entities;

public class EtudiantAlternance  extends Etudiant{
    private int salaire;

    public EtudiantAlternance(){}
    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne, int salaire){
        super(identifiant, nom, prenom, moyenne);
        this.salaire = salaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public void ajouterUneAbsence() {
        this.salaire -= 50;
    }

    @Override
    public String toString() {
        return super.toString()+
                "salaire=" + salaire;
    }
}
