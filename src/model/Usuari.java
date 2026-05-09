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
    return this.nom;
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
    return this.llibresPrestats;
  }

  public void afegirLlibre(Llibre llibre) {
    this.llibresPrestats.add(llibre);
  }

  public void retornarLlibre(Llibre llibre) {
    this.llibresPrestats.remove(llibre);
  }

  @Override
  public String toString() {
    return "Usuari: " + this.nom + ", Llibres prestats: " + this.llibresPrestats.size();
  }

}
