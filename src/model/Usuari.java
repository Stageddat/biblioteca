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

  /**
   * Modificar el nom del usuari.
   * 
   * @param nom El nou nom de l'usuari.
   */
  public void setNom(String nom) {
    this.nom = nom;
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

  @Override
  public String toString() {
    return "Usuari: " + nom + ", Llibres prestats: " + llibresPrestats.size();
  }

}
