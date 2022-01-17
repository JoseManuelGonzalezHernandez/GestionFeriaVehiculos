package com.delecars.feria.vehiculos.terrestres;

import com.delecars.feria.vehiculos.Vehiculo;

public class Automovil extends Vehiculo{
    private static enum TiposTransmision { 
        manual,
        automatica
    };
    private TiposTransmision transmision;
    private int kms;
    private int puertas;
    
    public Automovil(String matricula, String marca, String color, int velMax, TiposTransmision transmision,
            int kms, int puertas) {
        super(matricula, marca ,color, velMax);
        this.transmision = transmision;
        this.kms = kms;
        this.puertas = puertas;
    }

    public Automovil() {
        this.transmision = generateTransmision();
        this.kms = generateKms();
        this.puertas = generatePuertas();
    }

    private TiposTransmision generateTransmision() {
        if (Math.random() < 0.5) {
            return TiposTransmision.automatica;
        }
        return TiposTransmision.manual;
    }

    private int generateKms() {
        return (int) (Math.random() * 1000000);
    }

    private int generatePuertas() {
        return (int) (Math.random() * 5);
    }

    @Override
    public String toString() {
        return "Automovil -> " + this.getMarca() + " " + this.getMatricula();
    }

    
}
