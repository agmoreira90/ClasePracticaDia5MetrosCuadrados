package com.clasepracticadia5.metroscuadrados.services;

import com.clasepracticadia5.metroscuadrados.dto.CasaDTO;

public interface CasaService {

    CasaDTO calcularMetrosCuadrados(CasaDTO casa, String ubicacion);
}
