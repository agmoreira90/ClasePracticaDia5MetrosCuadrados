package com.clasepracticadia5.metroscuadrados.controllers;

import com.clasepracticadia5.metroscuadrados.dto.Casa;
import com.clasepracticadia5.metroscuadrados.services.CasaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CasaController {

    @PostMapping("/a")
    public ResponseEntity calcularMetrosCuadrados(@RequestBody Casa casa) {
        return CasaService.calcularMetrosCuadrados(casa);
    }

    @PostMapping("/b")
    public ResponseEntity calcularValor(@RequestBody Casa casa) {
        return CasaService.calcularValor(casa);
    }

    @PostMapping("/c")
    public ResponseEntity calcularHabitacion(@RequestBody Casa casa) {
        return CasaService.calcularHabitacion(casa);
    }

    @PostMapping("/d")
    public ResponseEntity calcularHabitaciones(@RequestBody Casa casa) {
        return CasaService.calcularHabitaciones(casa);
    }

}
