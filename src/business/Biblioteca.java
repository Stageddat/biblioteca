package business;

import java.util.ArrayList;
import java.util.List;
import model.Llibre;
import model.Usuari;

/**
 * Classe biblioteca. Controla els llibres i usuaris
 */
public class Biblioteca {
  private List<Llibre> llibres;
  private List<Usuari> usuaris;

  /**
   * Constructor de la classe Biblioteca
   */
  public Biblioteca() {
    this.llibres = new ArrayList<>();
    this.usuaris = new ArrayList<>();
  }

  /**
   * Afegeix un llibre a la biblioteca
   * 
   * @param llibre El llibre que s'hi vol afegir
   */
  public void afegirLlibre(Llibre llibre) {
    llibres.add(llibre);
  }

  /**
   * Elimina un llibre de la biblioteca
   * 
   * @param titol Titol del llibre que s'hi vol eliminar
   * @return true si s'ha pogut eliminar el llibre, false en cas contrari
   */
  public boolean eliminarLlibre(String titol) {
    Llibre llibre = buscarLlibre(titol);
    if (llibre != null && !llibre.esPrestat()) {
      return llibres.remove(llibre);
    }
    return false;
  }

  /**
   * Busca un llibre per titol
   * 
   * @param titol Titol del llibre que s'hi vol buscar
   * @return El llibre si s'ha trobat, null en cas contrari
   */
  public Llibre buscarLlibre(String titol) {
    for (Llibre llibre : llibres) {
      if (llibre.getTitol().equalsIgnoreCase(titol))
        return llibre;
    }
    return null;
  }

  /**
   * Llista els llibres de la biblioteca
   * 
   * @return Llista de llibres
   */
  public List<Llibre> llistarLlibres() {
    return getLlibres();
  }

  /**
   * Afegeix un usuari a la biblioteca
   * 
   * @param usuari El usuari que s'hi vol afegir
   */
  public void afegirUsuari(Usuari usuari) {
    usuaris.add(usuari);
  }

  /**
   * Elimina un usuari de la biblioteca
   * 
   * @param nom Nom de l'usuari que s'hi vol eliminar
   * @return true si s'ha pogut eliminar l'usuari, false en cas contrari
   */
  public boolean eliminarUsuari(String nom) {
    Usuari usuari = buscarUsuari(nom);
    if (usuari != null && usuari.getLlibresPrestats().isEmpty()) {
      return usuaris.remove(usuari);
    }
    return false;
  }

  public List<Usuari> llistarUsuaris() {
    return getUsuaris();
  }

  /**
   * Busca un usuari per nom
   * 
   * @param nom Nom de l'usuari que s'hi vol buscar
   * @return El usuari si s'ha trobat, null en cas contrari
   */
  public Usuari buscarUsuari(String nom) {
    for (Usuari usuari : usuaris) {
      if (usuari.getNom().equalsIgnoreCase(nom))
        return usuari;
    }
    return null;
  }

  private List<Llibre> getLlibres() {
    return llibres;
  }

  private List<Usuari> getUsuaris() {
    return usuaris;
  }
}