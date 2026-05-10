package model;

import java.time.LocalDate;

/**
 * Classe de prestació de llibres. Relaciona un usuari amb un llibre.
 * 
 * @author Joaquim
 * @version 1.0
 */
public class Prestec {
  private Usuari usuari;
  private Llibre llibre;
  private LocalDate dataPrestec;
  private LocalDate dataRetorn;

  /**
   * Constructor de la classe Prestec.
   * 
   * @param usuari      Usuari que presta el llibre.
   * @param llibre      Llibre prestat.
   * @param dataPrestec Data de prestat del llibre.
   */
  public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
    this.usuari = usuari;
    this.llibre = llibre;
    this.dataPrestec = dataPrestec;
    this.dataRetorn = dataPrestec.plusWeeks(2);
  }

  /**
   * Retorna l'usuari que presta el llibre.
   * 
   * @return Usuari que presta el llibre.
   */
  public Usuari getUsuari() {
    return usuari;
  }

  /**
   * Retorna el llibre prestat.
   * 
   * @return Llibre prestat.
   */
  public Llibre getLlibre() {
    return llibre;
  }

  /**
   * Retorna la data de prestat del llibre.
   * 
   * @return Data de prestat del llibre.
   */
  public LocalDate getDataRetorn() {
    return dataRetorn;
  }

  /**
   * Retorna la data de prestat del llibre.
   * 
   * @return Data de prestat del llibre.
   */
  public LocalDate getDataPrestec() {
    return dataPrestec;
  }

  // Controlar el màxim de llibres que es poden demanar.
  // Nombre màxim de llibres que un usuari pot tenir en préstec.
  private static final int MAX_LLIBRES_PER_USUARI = 3;

  /**
   * Retorna el màxim de llibres que es poden demanar.
   * 
   * @return Màxim de llibres que un usuari pot tenir en préstec.
   */
  public static int getMaxLlibresPerUsuari() {
    return MAX_LLIBRES_PER_USUARI;
  }

  /**
   * Controla si un usuari pot demanar un altre llibre.
   * 
   * @param nombrePrestecActuals Nombre de llibres en prestat.
   * @return true si el usuari pot demanar un altre llibre, false en cas contrari.
   */
  public static boolean potDemanarPrestec(int nombrePrestecActuals) {
    return nombrePrestecActuals < MAX_LLIBRES_PER_USUARI;
  }

  /**
   * Comprova si el préstec està retardat.
   * 
   * @return true si el préstec està retardat, false en cas contrari.
   */
  public boolean estaRetardat() {
    return LocalDate.now().isAfter(dataRetorn);
  }

  /**
   * Comprova si el préstec ja ha estat retornat.
   * 
   * @return true si el préstec ja ha estat retornat, false en cas contrari.
   */
  public boolean estaRetornat() {
    return !LocalDate.now().isBefore(dataRetorn);
  }

  /**
   * Aumenta la data de retorn del llibre.
   * 
   * @return true si s'ha pogut aumentar la data de retorn, false en cas contrari.
   */
  public boolean allargarPrestec() {
    if (estaRetardat()) {
      return false;
    }
    dataRetorn = dataRetorn.plusWeeks(1);
    return true;
  }

  /**
   * Retorna els dies de retard del llibre.
   *
   * @return Dies de retard del llibre.
   */
  public long diesDeRetard() {
    LocalDate avui = LocalDate.now();
    if (avui.isAfter(dataRetorn)) {
      return dataRetorn.until(avui).getDays();
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Prestec{" +
        "usuari=" + usuari.getNom() +
        ", llibre=" + llibre.getTitol() +
        ", dataPrestec=" + dataPrestec +
        ", dataRetorn=" + dataRetorn +
        ", retardat=" + estaRetardat() +
        '}';
  }

}
