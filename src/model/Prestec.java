package model;

import java.time.LocalDate;

public class Prestec {
  // Propietats
  private Usuari usuari;
  private Llibre llibre;
  private LocalDate dataPrestec;
  private LocalDate dataRetorn;

  // Constructor
  public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
    this.usuari = usuari;
    this.llibre = llibre;
    this.dataPrestec = dataPrestec;
    this.dataRetorn = dataPrestec.plusWeeks(2);
  }

  // Getters
  public Usuari getUsuari() {
    return usuari;
  }

  public Llibre getLlibre() {
    return llibre;
  }

  public LocalDate getDataRetorn() {
    return dataRetorn;
  }

  public LocalDate getDataPrestec() {
    return dataPrestec;
  }

  // Mètodes

  // Controlar el màxim de llibres que es poden demanar.
  // Nombre màxim de llibres que un usuari pot tenir en préstec.
  private static final int MAX_LLIBRES_PER_USUARI = 3;

  public static int getMaxLlibresPerUsuari() {
    return MAX_LLIBRES_PER_USUARI;
  }

  // Comprova si un usuari pot demanar un nou préstec
  // basant-se en el nombre de préstecs actuals que té.
  public static boolean potDemanarPrestec(int nombrePrestecActuals) {
    return nombrePrestecActuals < MAX_LLIBRES_PER_USUARI;
  }

  // Gestió de préstecs
  // Comprova si préstec està retardat respecte a la data actual.
  public boolean estaRetardat() {
    return LocalDate.now().isAfter(dataRetorn);
  }

  // Comprova si el préstec ja ha estat retornat (data de retorn passada o avui).
  public boolean estaRetornat() {
    return !LocalDate.now().isBefore(dataRetorn);
  }

  // Allarga el préstec una setmana addicional, sempre que no estigui retardat.
  // Retorna true si s'ha pogut allargar, false en cas contrari.
  public boolean allargarPrestec() {
    if (estaRetardat()) {
      return false;
    }
    dataRetorn = dataRetorn.plusWeeks(1);
    return true;
  }

  // Calcula els dies de retard del préstec. Retorna 0 si no hi ha retard.
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
