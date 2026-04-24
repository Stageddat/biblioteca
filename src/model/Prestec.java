package model;

import java.time.LocalDate;
public class Prestec {

    // Propietats
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;


    private static final int MAX_LLIBRES = 3;

    public String prestecs(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {

        // Control del màxim de llibres
        if (usuari.getLlibresPrestats().size() >= MAX_LLIBRES) {
            return "L'usuari ha arribat al màxim de llibres permesos.";
        }

    // Constructor
    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2);
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public Llibre getLlibre() {
        return llibre;
    }

    public LocalDate getDataRetorn() {
        return dataRetorn;
    }
    
    

} 
