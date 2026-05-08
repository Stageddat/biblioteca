package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Llibre;
import model.Usuari;
import model.Prestec;

public class GestorBiblioteca {

    private List<Prestec> prestecs;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    /**
     * Prestar un llibre a un usuari.
     * 
     * @param usuari
     * @param llibre
     */
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);
            System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
        } else {
            System.out.println("Aquest llibre ja està prestat.");
        }
    }

    /**
     * Controlar stock de llibres disponibles. (si tenim més d'un llibre)
     * 
     * @param usuari Nom de l'usuari que vol agafar el llibre.
     * @param llibre El llibre que l'usuari vol agafar.
     * @return
     */
    public static boolean controlStock(Usuari usuari, Llibre llibre) {
        if (!llibre.esPrestat()) {
            System.out.println("El llibre " + llibre.getTitol() + " està disponible per a " + usuari.getNom());
            return true;
        }
        System.out.println("El llibre " + llibre.getTitol() + " no està disponible per a " + usuari.getNom()
                + " perquè ja està prestat.");
        return false;
    }

}
