package com.delecars.feria.gestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.delecars.feria.vehiculos.Vehiculo;
import com.delecars.feria.vehiculos.acuaticos.Barco;
import com.delecars.feria.vehiculos.terrestres.Automovil;
import com.delecars.feria.vehiculos.terrestres.Motocicleta;

public class Gestion {
    private ArrayList<Expositor> expositores;

    public Gestion(int numExpos, int numVehiculos) {
        this.expositores = new ArrayList<Expositor>();
        generateExpos(numExpos, numVehiculos);
        printExpos();
    }

    private void generateExpos(int numExpos, int numVehiculos) {
        int vehicleCount = 0;
        if (numVehiculos <= numExpos * 2) {
            for (int i = 0; i < numExpos; i++) {
                if (vehicleCount > numVehiculos) {
                    break;
                }
                ArrayList<Vehiculo> vehicleList = new ArrayList<Vehiculo>();
                vehicleList.add(generateRandomVehicle());
                vehicleCount++;
                this.expositores.add(new Expositor(vehicleList));
            }
            if (vehicleCount < numVehiculos) {
                int expoIndex = 0;
                while (vehicleCount < numVehiculos) {
                    Expositor actualExpo = this.expositores.get(expoIndex);
                    Vehiculo actualVehicle = actualExpo.vehiculos.get(0);
                    Vehiculo secondVehicle = generateSecondVehicle(actualVehicle);
                    actualExpo.vehiculos.add(secondVehicle);
                    this.expositores.set(expoIndex, actualExpo);
                    vehicleCount++;
                    expoIndex++;
                }
            }
        } else {
            System.out.println("ERROR: This configuration is impossible.");
        }
    }

    private Vehiculo generateRandomVehicle() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return new Automovil();
            case 1:
                return new Motocicleta();
            case 2:
                return new Barco();
            default:
                return null;
        }
    }

    private Vehiculo generateSecondVehicle(Vehiculo originalVehicle) {
        System.out.println(originalVehicle.getClass());
        if (originalVehicle.getClass() == Automovil.class) {
            return new Automovil();
        }
        if (originalVehicle.getClass() == Motocicleta.class) {
            return new Motocicleta();
        }
        return new Barco();
    }

    private void printExpos() {
        Iterator<Expositor> expoIterator = this.expositores.iterator();
        int expoNum = 1;
        while (expoIterator.hasNext()) {
            Expositor actualExpo = expoIterator.next();
            System.out.println("---------------- Expositor: " + expoNum + " ----------------");
            Iterator<Vehiculo> vehicleIterator = actualExpo.vehiculos.iterator();
            while (vehicleIterator.hasNext()) {
                Vehiculo actualVehicle = vehicleIterator.next();
                System.out.println(actualVehicle);
            }
            System.out.println("=========================================================");
            expoNum++;
        }
    }
}
