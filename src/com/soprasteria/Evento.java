package com.soprasteria;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento implements Comparable<Evento> {
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String titolo;
    private LocalDate data;
    private int postiTot;
    private int postiPrenotati = 0;

    //costruttori
    public Evento(String titolo, String data, int postiTot) throws IllegalArgumentException, DateTimeParseException {
        validPosti(postiTot);

        this.titolo = titolo;
        this.data = validData(data);
        this.postiTot = postiTot;
        this.postiPrenotati = 0;
    }

    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) throws IllegalArgumentException {
        this.data = validData(data);
    }

    public int getPostiTot() {
        return postiTot;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }


    private LocalDate validData(String data) throws IllegalArgumentException, DateTimeParseException {
        LocalDate date = LocalDate.parse(data,format);
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato");
        }
        return date;
    }
    private void validPosti(int posti) throws IllegalArgumentException {
        if (posti<1)
            throw new IllegalArgumentException("Ci deve essere almeno un posto");
    }


    public void prenota() throws Exception {
        if (LocalDate.now().isAfter(data)) {
            throw new Exception("Impossibile prenotare eventi già passati.");
        } else if (postiTot==postiPrenotati) {
            throw new Exception("Non ci sono abbastanza posti disponibili.");
        } else
            postiPrenotati++;
    }
    public void disdici() throws Exception {
        if (LocalDate.now().isAfter(data)) {
            throw new Exception("Impossibile disdire eventi già passati");
        } else if (postiPrenotati<1) {
            throw new Exception("Non ci sono prenotazioni per questo evento");
        }else
            postiPrenotati--;
    }


    @Override
    public String toString() {
        return "L'evento è in data "+ format.format(data)+" e il titolo è "+titolo;
    }

}