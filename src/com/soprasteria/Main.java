package com.soprasteria;


import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ciao inserisci i dati dell'evento:");
        Scanner scan = new Scanner(System.in);

        String titolo;
        String data;
        int posti=0;

        //chiedere i dati dell'evento all'utente
        System.out.println("Inserisci il titolo dell'evento");
        titolo= scan.nextLine();
        System.out.println("Inserisci la data dell'evento (gg/mm/aaaa) : ");
        data = scan.nextLine();

        try {       
            System.out.println("Inserisci la quantità di posti:");
            posti = Integer.parseInt(scan.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Inserito valore non valido per il campo posti"); 
        }

       

    }
}