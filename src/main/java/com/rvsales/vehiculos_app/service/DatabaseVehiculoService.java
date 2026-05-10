package com.rvsales.vehiculos_app.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.rvsales.vehiculos_app.model.Vehiculo;
import com.rvsales.vehiculos_app.repository.VehiculoRepository;


@Service
@Primary
public class DatabaseVehiculoService implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public DatabaseVehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public List<Vehiculo> filtrarVehiculos(String pais, Double precioMax, Integer anoMin) {

        return vehiculoRepository.findAll().stream()
            .filter(v -> pais == null || v.getCurrentCountry().equalsIgnoreCase(pais))
            .filter(v -> precioMax == null || v.getLivePriceEurInclVat() <= precioMax)
            .filter(v -> anoMin == null || v.getModelYear() >= anoMin)
            .toList();
    }

    @Override
    public Vehiculo obtenerVehiculoPorVIN(String vin) {
        return vehiculoRepository.findByVin(vin).orElse(null);
    }
}