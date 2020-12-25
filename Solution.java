import java.util.ArrayList;
import java.util.Collections;

/**
 * Berechnet die Loesung zur 'Coding Challenge' von 'get-in-it.de'.
 * 
 * Hierbei sollen verschiedene Geraete verladen und moeglichst effizient versand werden.
 * Das Ergebnis wird an der Summe der Prioritaeten der insgesamt verladenen Geraete gemessen.
 * 
 * Copyright (c) 2020 - Jonas Kuehn
 * Die volle Lizenz kann unter https://github.com/JOKUE2002/Coding-Challenge-GetInIt eingesehen werden.
 */
class Solution {

    /**
     * Alle zu verladenden Geraete
     */
    ArrayList<Geraet> alleGeraete;

    /**
     * Die Transporter zum Versand
     * Werden später ordentlich intialisiert
     */
    Transporter t1 = new Transporter();
    Transporter t2 = new Transporter();

    /**
     * Berechnet die Loesung.
     * Hierzu werden folgende Schritte ausgefuehrt:
     * 
     * 1. Geraete parsen
     * 2. Geraete sortieren (absteigend nach Prioritaet pro Gramm)
     * 3. Für jedes Gerät entscheiden:
     * 3a. Wie viele passen noch in Transporter 1, wie viele in Transporter 2
     * 3b. Entsprechend verladen
     * 4. Transporter losschicken (Ergebnis ausgeben)
     */
    public Solution() {
        //DataParser dp = new DataParser(); 
        //Debug-Hardcode
        DataParser dp = new DataParser("/Users/jonas/Documents/GitHub/Coding-Challenge-GetInIt/data.csv");

        //1.
        alleGeraete = dp.parseFile();

        //Transportert 'ordentlich' initialisieren
        t1 = new Transporter(0, 1100000, 72400);
        t2 = new Transporter(1, 1100000, 85700);

        //2.
        Collections.sort(alleGeraete);

        //3.
        for (Geraet geraet : alleGeraete) {
            int numberLoadable = 0;

            //3a (Transporter 1)
            int remainingUsableWeight = t1.getRemainingUsableWeight();
            for (int i = 0; i < (geraet.getNumberRequested() - geraet.getNumberLoaded()); i++) {

                if (remainingUsableWeight < geraet.getWeight()) {
                    break;
                }
                numberLoadable++;

                remainingUsableWeight -= geraet.getWeight();
            }

            //3b (Transporter 1)
            t1.addFreight(geraet.copy(), numberLoadable);
            geraet.setNumberLoaded(geraet.getNumberLoaded() + numberLoadable);

            //3a (Transporter 2)
            numberLoadable = 0;
            remainingUsableWeight = t2.getRemainingUsableWeight();
            for (int i = 0; i < (geraet.getNumberRequested() - geraet.getNumberLoaded()); i++) {

                if (remainingUsableWeight < geraet.getWeight()) {
                    break;
                }
                numberLoadable++;

                remainingUsableWeight -= geraet.getWeight();
            }

            //3b (Transporter 2)
            t2.addFreight(geraet.copy(), numberLoadable);
        }

        //4.
        t1.print();
        t2.print();
    }

    public static void main(String[] args) {
        new Solution();
    }
}