import clases.Simuladortrafico;
import clases.Ubicacion;
import clases.Vehiculo;

import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Crear instancia del simulador
            Simuladortrafico simulador = new Simuladortrafico();

        // Crear un ScheduledExecutorService para ejecutar la tarea cada 10 segundos
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        // Definir la tarea a ejecutar periódicamente usando una clase anónima
        Runnable tareaGenerarInformacion = new Runnable() {
            @Override
            public void run() {
                LocalTime startTime = LocalTime.now();
                List<Ubicacion> ubicacionesSimuladas = simulador.Simular();
                System.out.println("Información de tráfico generada:");

                for (Ubicacion ubicacion : ubicacionesSimuladas) {
                    System.out.println("Ubicación: " + ubicacion.getNombre() + " en " + ubicacion.getCiudad());
                    System.out.println("Densidad: " + ubicacion.getDensidad());
                    System.out.println("Hora: " + startTime);
                    System.out.println("Número de Vehículos: " + ubicacion.contarVehiculos());
                    System.out.println("Velocidad Promedio: " + ubicacion.calcularVelocidadPromedio() + " km/h");
                    System.out.println("Vehículos:");
                    for (Vehiculo vehiculo : ubicacion.getVehiculos()) {
                        System.out.println("- Tipo: " + vehiculo.getTipo() + ", Velocidad: " + vehiculo.getVelocidad() + " km/h," + " Marca: "+
                                vehiculo.getMarca() + " ,Color: " + vehiculo.getColor() + ",Placa: "+ vehiculo.getPlaca());
                    }
                    System.out.println();
                }
            }
        };

        // Programar la ejecución de la tarea cada 10 segundos
        executorService.scheduleAtFixedRate(tareaGenerarInformacion, 0, 5, TimeUnit.SECONDS);

        // El programa seguirá corriendo indefinidamente, para detenerlo, puedes hacer un shutdown.
        // executorService.shutdown();
    }
}
