package com.delecars.feria.vehiculos;

import java.util.Random;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String[] marcas = {
        "Ferrari",
        "Maserati",
        "Porsche",
        "Audi Accidentado",
        "Suzuki"
    };
    private String color;
    private String[] colors = {
        "blanco",
        "negro",
        "rojo",
        "azul",
        "naranja"
    };
    private int velMax;
    
    

    public Vehiculo(String matricula, String marca, String color, int velMax) {
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
        this.velMax = velMax;
    }

    public Vehiculo() {
        this.matricula = generateMatricula();
        this.color = generateColor();
        this.velMax = generateVelMax();
        this.marca = generateMarca();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    private String generateMatricula() {
        Random random = new Random();
        String matricula = random.nextInt(9999) + " " + (char) (random.nextInt(26) + 'a') + (char) (random.nextInt(26) + 'a') + (char) (random.nextInt(26) + 'a');

        return matricula;
    }

    private String generateMarca() {
        return (String) marcas[(int) (Math.random() * marcas.length)];
    }

    private String generateColor() {
        return (String) colors[(int) (Math.random() * colors.length)];
    }

    public int generateVelMax() {
        return (int) (Math.random() * 200);
    }
}
