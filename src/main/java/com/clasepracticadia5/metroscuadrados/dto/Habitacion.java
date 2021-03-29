package com.clasepracticadia5.metroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    private String nombre;
    private Double ancho;
    private Double largo;
    private Double metrosCuadrados;

    public Habitacion(String nombre, Double ancho, Double largo) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.metrosCuadrados = 0.0;
    }
}
