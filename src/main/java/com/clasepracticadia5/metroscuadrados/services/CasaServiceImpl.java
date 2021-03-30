package com.clasepracticadia5.metroscuadrados.services;

import com.clasepracticadia5.metroscuadrados.dto.CasaDTO;
import com.clasepracticadia5.metroscuadrados.dto.Habitacion;
import com.clasepracticadia5.metroscuadrados.dto.PrecioDTO;
import com.clasepracticadia5.metroscuadrados.repositories.PrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class CasaServiceImpl implements CasaService{

    private final PrecioRepository precioRepository;

    public CasaServiceImpl(PrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    public CasaDTO calcularMetrosCuadrados(CasaDTO casaDTO,String ubicacion) {
        metros(casaDTO);
        habitacion(casaDTO);
        valor(casaDTO,ubicacion);
        return casaDTO;
    }


    public CasaDTO calcularValor(CasaDTO casaDTO,String ubicacion) {

        metros(casaDTO);
        habitacion(casaDTO);
        valor(casaDTO,ubicacion);
        return casaDTO;
    }

    public Habitacion calcularHabitacion(CasaDTO casaDTO,String ubicacion) {
        metros(casaDTO);
        habitacion(casaDTO);
        valor(casaDTO,ubicacion);
        return casaDTO.getHabitacionMasGrande();
    }


    public ArrayList<Habitacion> calcularHabitaciones(CasaDTO casaDTO) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        metros(casaDTO);
        habitaciones = casaDTO.getHabitaciones();
        return habitaciones;
    }

    private void metros(CasaDTO casaDTO) {
        if (casaDTO.getHabitaciones() != null) {
            for (int i = 0; i < casaDTO.getHabitaciones().size(); i++) {
                casaDTO.getHabitaciones().get(i).setMetrosCuadrados(casaDTO.getHabitaciones().get(i).getLargo() * casaDTO.getHabitaciones().get(i).getAncho());
                if (casaDTO.getMetrosCuadrados() != null) {
                    casaDTO.setMetrosCuadrados(casaDTO.getMetrosCuadrados() + casaDTO.getHabitaciones().get(i).getMetrosCuadrados());
                } else {
                    casaDTO.setMetrosCuadrados(0.0);
                    casaDTO.setMetrosCuadrados(casaDTO.getMetrosCuadrados() + casaDTO.getHabitaciones().get(i).getMetrosCuadrados());
                }
            }
        }
    }

    private void valor(CasaDTO casaDTO, String ubicacion) {
        PrecioDTO precioDTO = precioRepository.findPrecioPorUbicacion(ubicacion);
        if (casaDTO.getHabitaciones() != null && casaDTO.getMetrosCuadrados() != null) {
            casaDTO.setPrecio(precioDTO.getPrecio() * casaDTO.getMetrosCuadrados());
        } else {
            metros(casaDTO);
            casaDTO.setPrecio(800 * casaDTO.getMetrosCuadrados());
        }
    }

    private void habitacion(CasaDTO casaDTO) {
        if (casaDTO.getHabitaciones() != null) {
            Habitacion habitacionMasGrande = new Habitacion();
            habitacionMasGrande.setMetrosCuadrados(0.0);
            for (int i = 0; i < casaDTO.getHabitaciones().size(); i++) {
                if (habitacionMasGrande.getMetrosCuadrados() < casaDTO.getHabitaciones().get(i).getMetrosCuadrados()) {
                    habitacionMasGrande = casaDTO.getHabitaciones().get(i);
                }
            }
            casaDTO.setHabitacionMasGrande(habitacionMasGrande);
        }
    }
}
