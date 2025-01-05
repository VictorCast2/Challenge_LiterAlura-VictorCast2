package com.LiterAlura.VictCast.LiterAlura.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}