package com.clasepracticadia5.metroscuadrados.repositories;

import com.clasepracticadia5.metroscuadrados.dto.PrecioDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PrecioRepositoryimpl implements PrecioRepository {
    @Override
    public PrecioDTO findPrecioPorUbicacion(String ubicacion) {
        List<PrecioDTO> preciosDTO = null;
        preciosDTO = cargarBase();
        PrecioDTO result = null;
        if (preciosDTO != null) {
            Optional<PrecioDTO> item = preciosDTO.stream().filter(precioDTO -> precioDTO.getUbicacion().equals(ubicacion)).findFirst();
            if (item.isPresent()) {
                result = item.get();
            }
        }
        return result;
    }

    private List<PrecioDTO> cargarBase() {
        File file = null;
        List<PrecioDTO> preciosDTO = null;
        try {
            file = ResourceUtils.getFile("classpath:precios.json");
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<PrecioDTO>> typeRef = new TypeReference<List<PrecioDTO>>() {
            };
            preciosDTO = objectMapper.readValue(file, typeRef);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return preciosDTO;
    }
}
