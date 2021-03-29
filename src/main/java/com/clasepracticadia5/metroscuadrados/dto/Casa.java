package com.clasepracticadia5.metroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Casa {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;
    private Habitacion habitacionMasGrande;
    private Double metrosCuadrados;
    private Double precio;

    public Casa(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
        this.habitacionMasGrande = new Habitacion();
        this.metrosCuadrados = 0.0;
        this.precio = 0.0;
    }
    public Casa(String nombre, String direccion,ArrayList<Habitacion> habitaciones,Double metrosCuadrados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = habitaciones;
        this.habitacionMasGrande = new Habitacion();
        this.metrosCuadrados = metrosCuadrados;
        this.precio = 0.0;
    }
}
