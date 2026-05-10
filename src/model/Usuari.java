package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuari de la biblioteca.
 * 
 * @author Aleix
 * @version 1.0
 */
public class Usuari {
  private String nom;
  private List<Llibre> llibresPrestats;

  /**
   * Constructor d'Usuari.
   */
  public Usuari(String nom) {
    this.nom = nom;
    this.llibresPrestats = new ArrayList<>();
  }

  /**
   * Obtenir el nom de l'usuari.
   * 
   * @return El nom de l'usuari.
   */
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

  /**
   * Obtenir la llista de llibres prestats.
   * 
   * @return La llista de llibres prestats.
   */
  public List<Llibre> getLlibresPrestats() {
    return this.llibresPrestats;
  }

  /**
   * Afegeix un llibre a la llista de llibres prestats.
   * 
   * @param llibre El llibre que s'hi vol afegir.
   */
  public void afegirLlibre(Llibre llibre) {
    this.llibresPrestats.add(llibre);
  }

  /**
   * Elimina un llibre de la llista de llibres prestats.
   * 
   * @param llibre El llibre que s'hi vol eliminar.
   */
  public void retornarLlibre(Llibre llibre) {
    this.llibresPrestats.remove(llibre);
  }

  @Override
  public String toString() {
    return "Usuari: " + this.nom + ", Llibres prestats: " + this.llibresPrestats.size();
  }

}
