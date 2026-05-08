package model;

import java.util.ArrayList;
import java.util.List;

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
    for (Llibre cadaLlibre : llibresPrestats) {
      if (cadaLlibre.getTitol().equalsIgnoreCase(llibre.getTitol())) {
        llibresPrestats.remove(llibre);
        return;
      }
    }
  }

  /**
   * Modificar el nom d'un usuari.
   * 
   * @param nom El nou nom de l'usuari.
   */

  public void setNom(String nom) {
    this.nom = nom;
  }

  // LlISTAR User
  /**
   * Llistar les dades d'un usuari, incloent el seu nom i els llibres que té
   */

  public void llistarUsuari() {
    System.out.println("Nom: " + nom);
    System.out.print("Llibres prestats: ");
    for (Llibre llibre : llibresPrestats) {
      System.out.println(llibre.getTitol() + "- ");
    }
  }

  /**
   * Cercar un usuari per nom en una llista d'usuaris.
   * 
   * @param usuaris Llista d'usuaris on buscar.
   * @param nom     Nom de l'usuari a cercar.
   * @return L'usuari trobat o null si no s'ha trobat.
   */
  public static Usuari cercarUsuari(List<Usuari> usuaris, String nom) {
    for (Usuari usuari : usuaris) {
      if (usuari.getNom().equalsIgnoreCase(nom)) {
        return usuari;
      }
    }
    return null;
  }

  /**
   * Eliminar un usuari de la llista d'usuaris.
   * 
   * @param usuaris Llista d'usuaris de la qual eliminar.
   * @param nom     Nom de l'usuari a eliminar.
   * @return true si s'ha eliminat l'usuari, false si no s'ha trobat o té llibres
   *         prestats.
   */
  public static boolean eliminarUsuari(List<Usuari> usuaris, String nom) {
    for (Usuari usuari : usuaris) {
      if (usuari.getNom().equalsIgnoreCase(nom)) {
        if (usuari.getLlibresPrestats().isEmpty()) {
          usuaris.remove(usuari);
          return true;
        } else {
          System.out.println("No es pot eliminar l'usuari " + nom + " perquè té llibres prestats.");
          return false;
        }
      }
    }
    System.out.println("No s'ha trobat l'usuari " + nom + ".");
    return false;
  }

}
