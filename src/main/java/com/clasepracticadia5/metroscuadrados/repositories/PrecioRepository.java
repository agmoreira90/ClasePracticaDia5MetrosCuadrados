package com.clasepracticadia5.metroscuadrados.repositories;

import com.clasepracticadia5.metroscuadrados.dto.PrecioDTO;

public interface PrecioRepository {

    PrecioDTO findPrecioPorUbicacion(String ubicacion);

}
