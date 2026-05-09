package app;

import business.Biblioteca;
import business.GestorBiblioteca;
import model.Llibre;
import model.Usuari;

import java.util.Scanner;

public class Main {
  private static Biblioteca biblioteca = new Biblioteca();
  private static GestorBiblioteca gestor = new GestorBiblioteca();
  private static Scanner teclat = new Scanner(System.in);

  public static void main(String[] args) {
    // dades de prova
    Llibre marina = new Llibre("Marina", "Carlos Ruiz");
    Llibre elPetitPrincep = new Llibre("El petit príncep", "Antoine");
    Llibre donQuijote = new Llibre("Don Quijote", "Miguel de Cervantes");
    Llibre harryPotter = new Llibre("Harry Potter", "J.K. Rowling");
    Llibre elSenyor = new Llibre("El senyor dels anells", "J.R.R. Tolkien");

    biblioteca.afegirLlibre(marina);
    biblioteca.afegirLlibre(elPetitPrincep);
    biblioteca.afegirLlibre(donQuijote);
    biblioteca.afegirLlibre(harryPotter);
    biblioteca.afegirLlibre(elSenyor);

    Usuari aleix = new Usuari("Aleix");
    Usuari marc = new Usuari("Marc");
    Usuari joaquim = new Usuari("Joaquim");
    Usuari jose = new Usuari("Jose");

    biblioteca.afegirUsuari(aleix);
    biblioteca.afegirUsuari(marc);
    biblioteca.afegirUsuari(joaquim);
    biblioteca.afegirUsuari(jose);

    gestor.prestarLlibre(aleix, marina);
    gestor.prestarLlibre(joaquim, harryPotter);
    gestor.prestarLlibre(joaquim, elSenyor);

    // bucle de menu
    int opcio;
    do {
      mostrarMenu();
      opcio = teclat.nextInt();
      switch (opcio) {
        case 1 -> menuLlibres();
        case 2 -> menuUsuaris();
        case 3 -> menuPrestecs();
        case 0 -> System.out.println("Sortint...");
        default -> System.out.println("Opció no vàlida.");
      }
    } while (opcio != 0);

    teclat.close();
  }

  private static void mostrarMenu() {
    System.out.println();
    System.out.println("=== GESTIÓ BIBLIOTECA ===");
    System.out.println("1. Gestionar llibres");
    System.out.println("2. Gestionar usuaris");
    System.out.println("3. Gestionar préstecs");
    System.out.println("0. Sortir");
    System.out.print("Opció: ");
  }

  private static void menuLlibres() {
    System.out.println();
    System.out.println("--- LLIBRES ---");
    System.out.println("1. Afegir llibre");
    System.out.println("2. Eliminar llibre");
    System.out.println("3. Buscar llibre");
    System.out.println("4. Llistar llibres");
    System.out.print("Opció: ");

    switch (teclat.nextInt()) {
      case 1 -> afegirLlibre();
      case 2 -> eliminarLlibre();
      case 3 -> buscarLlibre();
      case 4 -> llistarLlibres();
      default -> System.out.println("Opció no vàlida.");
    }
  }

  private static void menuUsuaris() {
    System.out.println();
    System.out.println("--- USUARIS ---");
    System.out.println("1. Afegir usuari");
    System.out.println("2. Eliminar usuari");
    System.out.println("3. Buscar usuari");
    System.out.println("4. Llistar usuaris");
    System.out.print("Opció: ");

    switch (teclat.nextInt()) {
      case 1 -> afegirUsuari();
      case 2 -> eliminarUsuari();
      case 3 -> buscarUsuari();
      case 4 -> llistarUsuaris();
      default -> System.out.println("Opció no vàlida.");
    }
  }

  private static void menuPrestecs() {
    System.out.println();
    System.out.println("--- PRÉSTECS ---");
    System.out.println("1. Prestar llibre");
    System.out.println("2. Retornar llibre");
    System.out.print("Opció: ");

    switch (teclat.nextInt()) {
      case 1 -> prestarLlibre();
      case 2 -> retornarLlibre();
      default -> System.out.println("Opció no vàlida.");
    }
  }

  private static void afegirLlibre() {
    System.out.print("Títol: ");
    String titol = teclat.nextLine();
    System.out.print("Autor: ");
    String autor = teclat.nextLine();
    biblioteca.afegirLlibre(new Llibre(titol, autor));
    System.out.println("Llibre afegit correctament.");
  }

  private static void eliminarLlibre() {
    System.out.print("Llibre a eliminar: ");
    String titol = teclat.nextLine();
    if (biblioteca.eliminarLlibre(titol)) {
      System.out.println("Llibre eliminat correctament.");
    } else {
      System.out.println("No s'ha pogut eliminar el llibre.");
    }
  }

  private static void buscarLlibre() {
    System.out.print("Llibre a buscar: ");
    String titol = teclat.nextLine();
    Llibre llibre = biblioteca.buscarLlibre(titol);
    if (llibre != null) {
      System.out.println("Llibre trobat: " + llibre);
    } else {
      System.out.println("No s'ha pogut trobar el llibre.");
    }
  }

  private static void llistarLlibres() {
    var llibres = biblioteca.llistarLlibres();
    if (llibres.isEmpty()) {
      System.out.println("No hi ha llibres a la biblioteca.");
      return;
    }
    System.out.println("\n--- Llibres ---");
    for (Llibre llibre : llibres) {
      System.out.println("  " + llibre);
    }
  }

  private static void afegirUsuari() {
    System.out.print("Nom de l'usuari: ");
    String nom = teclat.nextLine();
    biblioteca.afegirUsuari(new Usuari(nom));
    System.out.println("Usuari afegit correctament.");
  }

  private static void eliminarUsuari() {
    System.out.print("Usuari a eliminar: ");
    String nom = teclat.nextLine();
    if (biblioteca.eliminarUsuari(nom)) {
      System.out.println("Usuari eliminat correctament.");
    } else {
      System.out.println("No s'ha pogut eliminar l'usuari.");
    }
  }

  private static void buscarUsuari() {
    System.out.print("Usuari a buscar: ");
    String nom = teclat.nextLine();
    Usuari usuari = biblioteca.buscarUsuari(nom);
    if (usuari != null) {
      System.out.println("Trobat: " + usuari);
    } else {
      System.out.println("Usuari no trobat.");
    }
  }

  private static void llistarUsuaris() {
    var usuaris = biblioteca.llistarUsuaris();
    if (usuaris.isEmpty()) {
      System.out.println("No hi ha usuaris registrats.");
      return;
    }
    System.out.println("\n--- Usuaris ---");
    for (Usuari u : usuaris) {
      System.out.println("  " + u);
    }
  }

  private static void prestarLlibre() {
    System.out.print("Nom de l'usuari: ");
    String nomUsuari = teclat.nextLine();
    Usuari usuari = biblioteca.buscarUsuari(nomUsuari);
    if (usuari == null) {
      System.out.println("Usuari no trobat.");
      return;
    }

    System.out.print("Llibre a prestar: ");
    String titol = teclat.nextLine();
    Llibre llibre = biblioteca.buscarLlibre(titol);
    if (llibre == null) {
      System.out.println("Llibre no trobat.");
      return;
    }

    gestor.prestarLlibre(usuari, llibre);
  }

  private static void retornarLlibre() {
    System.out.print("Usuari: ");
    String nomUsuari = teclat.nextLine();
    Usuari usuari = biblioteca.buscarUsuari(nomUsuari);
    if (usuari == null) {
      System.out.println("Usuari no trobat.");
      return;
    }

    System.out.print("Llibre: ");
    String titol = teclat.nextLine();
    Llibre llibre = biblioteca.buscarLlibre(titol);
    if (llibre == null) {
      System.out.println("Llibre no trobat.");
      return;
    }

    gestor.retornarLlibre(usuari, llibre);
  }
}