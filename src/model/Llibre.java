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

  /**
   * Retorna el titol del llibre
   * 
   * @return El titol del llibre
   */
  public String getTitol() {
    return titol;
  }

  /**
   * Retorna l'autor del llibre
   * 
   * @return L'autor del llibre
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Retorna si el llibre esta prestat o no
   * 
   * @return true si el llibre esta prestat, false en cas contrari
   */
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

  /**
   * Modificar el llibre
   * 
   * @param nouTitol Nou titol del llibre
   * @param nouAutor Nou autor del llibre
   */
  public void setLlibre(String nouTitol, String nouAutor) {
    this.titol = nouTitol;
    this.autor = nouAutor;
  }

}
