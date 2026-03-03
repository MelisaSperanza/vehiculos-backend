package com.rvsales.vehiculos_app.service;

import java.util.List;
import com.rvsales.vehiculos_app.model.Vehiculo;


public interface VehiculoService {

    List<Vehiculo> obtenerVehiculos();

    List<Vehiculo> filtrarVehiculos(String pais, Double precioMax, Integer anoMin);

}