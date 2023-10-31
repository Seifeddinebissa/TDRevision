package Exceptions;

public class EtudiantExisteException extends Exception{
    public EtudiantExisteException(){
        super("Cet étudiant est existe déjà!");
    }
}
