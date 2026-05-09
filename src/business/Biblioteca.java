package business;

import java.util.ArrayList;
import java.util.List;
import model.Llibre;
import model.Usuari;

public class Biblioteca {
  private List<Llibre> llibres;
  private List<Usuari> usuaris;

  public Biblioteca() {
    this.llibres = new ArrayList<>();
    this.usuaris = new ArrayList<>();
  }

  public void afegirLlibre(Llibre llibre) {
    llibres.add(llibre);
  }

  public boolean eliminarLlibre(String titol) {
    Llibre llibre = buscarLlibre(titol);
    if (llibre != null && !llibre.esPrestat()) {
      return llibres.remove(llibre);
    }
    return false;
  }

  public Llibre buscarLlibre(String titol) {
    for (Llibre llibre : llibres) {
      if (llibre.getTitol().equalsIgnoreCase(titol))
        return llibre;
    }
    return null;
  }

  public void afegirUsuari(Usuari usuari) {
    usuaris.add(usuari);
  }

  public boolean eliminarUsuari(String nom) {
    Usuari usuari = buscarUsuari(nom);
    if (usuari != null && usuari.getLlibresPrestats().isEmpty()) {
      return usuaris.remove(usuari);
    }
    return false;
  }

  public Usuari buscarUsuari(String nom) {
    for (Usuari usuari : usuaris) {
      if (usuari.getNom().equalsIgnoreCase(nom))
        return usuari;
    }
    return null;
  }

  public List<Llibre> getLlibres() {
    return llibres;
  }

  public List<Usuari> getUsuaris() {
    return usuaris;
  }
}