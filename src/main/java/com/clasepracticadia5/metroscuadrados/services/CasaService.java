package com.clasepracticadia5.metroscuadrados.services;

import com.clasepracticadia5.metroscuadrados.dto.Casa;
import com.clasepracticadia5.metroscuadrados.dto.Habitacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;


public class CasaService {
    public static ResponseEntity calcularMetrosCuadrados(Casa casa) {
        metros(casa);
        habitacion(casa);
        valor(casa);
        return new ResponseEntity(casa, HttpStatus.OK);
    }


    public static ResponseEntity calcularValor(Casa casa) {
        metros(casa);
        habitacion(casa);
        valor(casa);
        return new ResponseEntity(casa, HttpStatus.OK);
    }

    public static ResponseEntity calcularHabitacion(Casa casa) {
        metros(casa);
        habitacion(casa);
        valor(casa);
        return new ResponseEntity(casa.getHabitacionMasGrande(), HttpStatus.OK);
    }


    public static ResponseEntity calcularHabitaciones(Casa casa) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        metros(casa);
        habitaciones = casa.getHabitaciones();
        return new ResponseEntity(habitaciones, HttpStatus.OK);
    }

    private static void metros(Casa casa) {
        if (casa.getHabitaciones() != null) {
            for (int i = 0; i < casa.getHabitaciones().size(); i++) {
                casa.getHabitaciones().get(i).setMetrosCuadrados(casa.getHabitaciones().get(i).getLargo() * casa.getHabitaciones().get(i).getAncho());
                if (casa.getMetrosCuadrados() != null) {
                    casa.setMetrosCuadrados(casa.getMetrosCuadrados() + casa.getHabitaciones().get(i).getMetrosCuadrados());
                } else {
                    casa.setMetrosCuadrados(0.0);
                    casa.setMetrosCuadrados(casa.getMetrosCuadrados() + casa.getHabitaciones().get(i).getMetrosCuadrados());
                }
            }
        }
    }

    private static void valor(Casa casa) {
        if (casa.getHabitaciones() != null && casa.getMetrosCuadrados() != null) {
            casa.setPrecio(800 * casa.getMetrosCuadrados());
        } else {
            metros(casa);
            casa.setPrecio(800 * casa.getMetrosCuadrados());
        }
    }

    private static void habitacion(Casa casa) {
        if (casa.getHabitaciones() != null) {
            Habitacion habitacionMasGrande = new Habitacion();
            habitacionMasGrande.setMetrosCuadrados(0.0);
            for (int i = 0; i < casa.getHabitaciones().size(); i++) {
                if (habitacionMasGrande.getMetrosCuadrados() < casa.getHabitaciones().get(i).getMetrosCuadrados()) {
                    habitacionMasGrande = casa.getHabitaciones().get(i);
                }
            }
            casa.setHabitacionMasGrande(habitacionMasGrande);
        }
    }
}
