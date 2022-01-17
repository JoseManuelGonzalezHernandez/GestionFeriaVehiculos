package com.delecars.feria.gestion;

import java.util.ArrayList;

import com.delecars.feria.vehiculos.Vehiculo;

public class Expositor {
    ArrayList<Vehiculo> vehiculos;

    public Expositor(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String print() {
        String outPut = new String("");

        for (Vehiculo vehicle : vehiculos) {
            outPut += vehicle.toString();
        }
        return outPut;
    }
}
