package com.clasepracticadia5.metroscuadrados.controllers;

import com.clasepracticadia5.metroscuadrados.dto.CasaDTO;
import com.clasepracticadia5.metroscuadrados.dto.Habitacion;
import com.clasepracticadia5.metroscuadrados.services.CasaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/calculadora")
//@AllArgsConstructor
public class CasaController {

    @Autowired
    private CasaServiceImpl casaServiceImpl;

    @PostMapping("/a/{ubicacion}")
    public CasaDTO calcularMetrosCuadrados(@PathVariable String ubicacion,@RequestBody CasaDTO casaDTO) {
        return this.casaServiceImpl.calcularMetrosCuadrados(casaDTO,ubicacion);
    }

    @PostMapping("/b/{ubicacion}")
    public CasaDTO calcularValor(@PathVariable String ubicacion,@RequestBody CasaDTO casaDTO) {
        return this.casaServiceImpl.calcularValor(casaDTO,ubicacion);
    }

    @PostMapping("/c/{ubicacion}")
    public Habitacion calcularHabitacion(@PathVariable String ubicacion,@RequestBody CasaDTO casaDTO) {
        return this.casaServiceImpl.calcularHabitacion(casaDTO,ubicacion);
    }

    @PostMapping("/d")
    public ArrayList<Habitacion> calcularHabitaciones(@RequestBody CasaDTO casaDTO) {
        return this.casaServiceImpl.calcularHabitaciones(casaDTO);
    }

}
