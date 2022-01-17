package com.delecars.feria.vehiculos.acuaticos;

import com.delecars.feria.vehiculos.Vehiculo;

public class Barco extends Vehiculo{
    private double eslora;
    private double manga;
    
    public Barco(String matricula, String marca, String color, int velMax, double eslora, double manga) {
        super(matricula, marca, color, velMax);
        this.eslora = eslora;
        this.manga = manga;
    }

    public Barco() {
        this.eslora = generateEslora();
        this.manga = generateManga();
    }

    private double generateEslora() {
        return (Math.random() * 362);
    }

    private double generateManga() {
        return (Math.random() * 70);
    }

    @Override
    public String toString() {
        return "Barco -> " + this.getMarca() + " " + this.getMatricula();
    }
}
