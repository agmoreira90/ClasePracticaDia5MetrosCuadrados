package com.clasepracticadia5.metroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecioDTO {
    private String ubicacion;
    private Integer precio;
}
