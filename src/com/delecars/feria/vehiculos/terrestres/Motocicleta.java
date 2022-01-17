package com.delecars.feria.vehiculos.terrestres;

import com.delecars.feria.vehiculos.Vehiculo;

public class Motocicleta extends Vehiculo{
    private enum TiposMoto {
        enduro,
        deportiva,
        scooter
    }
    private TiposMoto tipo;
    private int ruedas;
    private int cilindrada;

    

    public Motocicleta(String matricula, String marca, String color, int velMax, TiposMoto tipo, int ruedas,
            int cilindrada) {
        super(matricula, marca, color, velMax);
        this.tipo = tipo;
        this.ruedas = ruedas;
        this.cilindrada = cilindrada;
    }

    public Motocicleta() {
        this.tipo = generateTipo();
        this.ruedas = generateRuedas();
        this.cilindrada = generateCilindrada();
    }

    private TiposMoto generateTipo() {
        double random = Math.random();
        if (random < 0.3) {
            return TiposMoto.deportiva;
        } else if (random < 0.6) {
            return TiposMoto.enduro;
        }
        return TiposMoto.scooter;
    }

    private int generateRuedas() {
        return (int) (Math.random() * 4);
    }

    private int generateCilindrada() {
        return (int) (Math.random() * 2500);
    }
    
    @Override
    public String toString() {
        return "Motocicleta -> " + this.getMarca() + " " + this.getMatricula();
    }

    
}
