package hu.petrik.emberekoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emberek {
    private List<Ember> emberLista;

    public Emberek(Ember[] emberTomb){
        this.emberLista = new ArrayList<>();
        // Tömböt átalakítottuk listává, és az összes elemet az addAll függvény segítségével felvettük.
        this.emberLista.addAll(Arrays.asList(emberTomb));
        /*
        for (Ember ember: emberTomb) {
            this.emberLista.add(ember);
        }
         */
    }

    public Emberek(String fajlNev){
        this.emberLista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null){
                String[] adatok = sor.split(";");
                Ember ember = new Ember(adatok[0], adatok[1], adatok[2]);
                this.emberLista.add(ember);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int honapbanSzuletett(int honap) {
        int db = 0;
        for (Ember ember: emberLista) {
            if (ember.getSzuletesiHonap() == honap) db++;
        }
        return db;
    }

    public int atlagEletkor() {
        int eletkor = 0;
        for (Ember ember : emberLista) {
            eletkor += ember.getEletkor();
        }
        return eletkor / emberLista.size();
    }

    public String legfiatalab() {
        Ember legfiatalabbEmber = emberLista.get(0);
        for (Ember e: emberLista) {
            if (e.getEletkor() < legfiatalabbEmber.getEletkor()) legfiatalabbEmber = e;
        }
        return legfiatalabbEmber.getNev();
    }

    public String legidosebb() {
        Ember legfiatalabbEmber = emberLista.get(0);
        for (Ember e: emberLista) {
            if (e.getEletkor() > legfiatalabbEmber.getEletkor()) legfiatalabbEmber = e;
        }
        return legfiatalabbEmber.getNev();
    }

    @Override
    public String toString() {
        String s = "";
        for (Ember ember: this.emberLista) {
            s += ember + "\n";
        }
        return s;
    }
}
