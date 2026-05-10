package model;

/**
 * Classe que representa un llibre
 * 
 * @author Jose
 * @version 1.0
 */
public class Llibre {
  private String titol;
  private String autor;
  private boolean prestat;

  /**
   * Constructor de la classe Llibre
   */
  public Llibre(String titol, String autor) {
    this.titol = titol;
    this.autor = autor;
    this.prestat = false;
  }

  public String getTitol() {
    return titol;
  }

  public String getAutor() {
    return autor;
  }

  public boolean esPrestat() {
    return prestat;
  }

  /**
   * Prestar el llibre
   */
  public void prestar() {
    prestat = true;
  }

  /**
   * Retornar el llibre
   */
  public void retornar() {
    prestat = false;
  }

  @Override
  public String toString() {
    return titol + " de " + autor + (prestat ? " (En préstec)" : " (Disponible)");
  }

  public void setLlibre(String nouTitol, String nouAutor) {
    this.titol = nouTitol;
    this.autor = nouAutor;
  }

}
