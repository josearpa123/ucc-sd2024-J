package clases;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
    private String ciudad;  // Cambiado a camelCase
    private String nombre;
    private List<Vehiculo> vehiculos;
    private String densidad;

    public Ubicacion(String ciudad, String densidad, String nombre) {
        this.ciudad = ciudad;
        this.densidad = densidad;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();  // Inicializar la lista
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getDensidad() {
        return densidad;
    }

    public void setDensidad(String densidad) {
        this.densidad = densidad;
    }

    public int contarVehiculos() {
        return this.vehiculos.size();
    }

    public double calcularVelocidadPromedio() {
        if (this.vehiculos.isEmpty()) {
            return 0.0; // Evitar división por cero si no hay vehículos
        }
        int suma = 0;
        for (Vehiculo vehiculo : vehiculos) {
            suma += vehiculo.getVelocidad();
        }
        return (double) suma / this.vehiculos.size();
    }
}
