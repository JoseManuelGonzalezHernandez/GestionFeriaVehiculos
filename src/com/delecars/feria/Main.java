package com.delecars.feria;

import com.delecars.feria.gestion.Gestion;

public class Main {
    public static void main(String[] args) {
        int numExpos = 6;
        int numVehiculos = 12;

        Gestion manager = new Gestion(numExpos, numVehiculos);
    }
}
