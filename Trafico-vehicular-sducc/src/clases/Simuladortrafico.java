package clases;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simuladortrafico {
    public static final String[] UBICACIONES = {"Calle 5","Carrera 1","Autopista sur","transversal",};
    public static final String[] VEHICULOS = {"Motos","Carros","Camiones","Camiones"};
    public static final String[] DENSIDAD ={"Baja", "Alta", "Media"};
    private static final int[] HORAS_PICO = {7, 8, 9, 17, 18, 19};

    public Random random = new Random();
     public List<Ubicacion> Simular (){
         List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
         for (String ubicacionnombre: UBICACIONES) {
             String densidad = DENSIDAD[random.nextInt(DENSIDAD.length)];
             Ubicacion ubicacion = new Ubicacion("Cali", densidad, ubicacionnombre);
             int cantidadvehiculos = generarCantidadVehiculos(densidad);
             for (int i = 0; i < cantidadvehiculos ; i++) {
                 String tipoVehiculo = VEHICULOS[random.nextInt(VEHICULOS.length)];
                 int velocidad = generarVelocidad(tipoVehiculo);
                 String marca = marca();
                 String color = color();
                 String placa = generarPlaca();
                 String commbustible= Combustible();
                 Vehiculo vehiculo = new Vehiculo(tipoVehiculo, velocidad, marca, color, placa, commbustible);
                 ubicacion.agregarVehiculo(vehiculo);
             }
             ubicaciones.add(ubicacion);
         }
         return ubicaciones;
     }

     private String marca(){
         String [] marcas = {"Kia", "Honda", "Toyota", "BMW", "Mazda"};
         return marcas[random.nextInt(marcas.length)];
     }
    private String color(){
        String [] color = {"Amarillo", "Azul", "Rojo", "Blanco", "Negro"};
        return color[random.nextInt(color.length)];
    }
    private String generarPlaca() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Letras posibles
        StringBuilder placa = new StringBuilder();

        // Generar tres letras aleatorias
        for (int i = 0; i < 3; i++) {
            placa.append(letras.charAt(random.nextInt(letras.length())));
        }

        // Generar tres números aleatorios
        for (int i = 0; i < 3; i++) {
            placa.append(random.nextInt(10)); // Números del 0 al 9
        }

        return placa.toString();
    }
    private String Combustible(){
        String [] combustible = {"Corriente", "Diesel", "Gas", "Electrico"};
        return combustible[random.nextInt(combustible.length)];
    }
    private int generarCantidadVehiculos(String densidad) {
        switch (densidad) {
            case "Alto":
                return 50 + random.nextInt(50);
            case "Medio":
                return 20 + random.nextInt(30);
            case "Bajo":
            default:
                return 5 + random.nextInt(15);
        }
    }

    private int generarVelocidad(String tipoVehiculo) {
        int baseSpeed = random.nextInt(20) + 20;
        switch (tipoVehiculo) {
            case "Camión":
                return baseSpeed - 10;
            case "Motocicleta":
                return baseSpeed + 20;
            case "Autobús":
                return baseSpeed - 5;
            case "Auto":
            default:
                return baseSpeed + 10;
        }
    }

    public boolean esHoraPico(int hora) {
        for (int horaPico : HORAS_PICO) {
            if (hora == horaPico) {
                return true;
            }
        }
        return false;
    }
}
