package model;

import java.util.ArrayList;
import java.util.List;

// Afegir User
public class Usuari {
  private String nom;
  private List<Llibre> llibresPrestats;

  public Usuari(String nom) {
    this.nom = nom;
    this.llibresPrestats = new ArrayList<>();
  }

  public String getNom() {
    return nom;
  }

  public List<Llibre> getLlibresPrestats() {
    return llibresPrestats;
  }

  public void afegirLlibre(Llibre llibre) {
    llibresPrestats.add(llibre);
  }

  public void retornarLlibre(Llibre llibre) {
    for(Llibre cadaLlibre : llibresPrestats) {
      if(cadaLlibre.getTitol().equalsIgnoreCase(libre.getTitol())) {
        llibresPrestats.remove(llibre);
        break;
      }
    }

  // MODIFICAR Usuario

  public void setNom(String nom) {
    this.nom = nom;
  }

  // ELIMINAR User

  /**
   * Elimina un llibre de la llista de llibres prestats de l'usuari.
   * 
   * @param llibre el llibre a eliminar
   */

  public void eliminarLlibre(Llibre llibre) {
    llibresPrestats.remove(llibre);
  }

  // LlISTAR User
  public void llistarUsuari() {
    System.out.println("Nom: " + nom);
    System.out.print("Llibres prestats: ");
    for (Llibre llibre : llibresPrestats) {
      System.out.println(llibre.getTitol() + "- ");
    }
  }

  // CERCAR User
  public static Usuari cercarUsuari(List<Usuari> usuaris, String nom) {
    for (Usuari usuari : usuaris) {
      if (usuari.getNom().equalsIgnoreCase(nom)) {
        return usuari;
      }
    }
    return null;
  }

  // ELIMINAR USER
  // MIRAR SI TIENE LIBRO, SI TIENE NO SE PUEDE
}
