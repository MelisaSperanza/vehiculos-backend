package com.rvsales.vehiculos_app.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvsales.vehiculos_app.model.Vehiculo;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MockVehiculoService implements VehiculoService {

    private final ObjectMapper objectMapper;

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    private final AtomicLong siguienteId = new AtomicLong(1);

    public MockVehiculoService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void cargarDatos() {

        try (InputStream inputStream = getClass()
                .getResourceAsStream("/mock/vehiculos.json")) {

            if (inputStream == null) {
                throw new IllegalStateException(
                    "No se encontró el archivo /mock/vehiculos.json"
                );
            }

            List<Vehiculo> datos = objectMapper.readValue(
                inputStream,
                new TypeReference<List<Vehiculo>>() {}
            );

            vehiculos.clear();
            vehiculos.addAll(datos);

            long maxId = vehiculos.stream()
                    .mapToLong(Vehiculo::getId)
                    .max()
                    .orElse(0);

            siguienteId.set(maxId + 1);

            System.out.println(
                "MOCK ACTIVADO - VEHICULOS CARGADOS: "
                + vehiculos.size()
            );

        } catch (Exception e) {
            throw new IllegalStateException(
                "No se pudieron cargar los vehículos mock",
                e
            );
        }
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    @Override
    public List<Vehiculo> filtrarVehiculos(
            String pais,
            Double precioMax,
            Integer anoMin) {

        return vehiculos.stream()
                .filter(v ->
                    pais == null ||
                    v.getCurrentCountry().equalsIgnoreCase(pais)
                )
                .filter(v ->
                    precioMax == null ||
                    v.getLivePriceEurInclVat() <= precioMax
                )
                .filter(v ->
                    anoMin == null ||
                    v.getModelYear() >= anoMin
                )
                .toList();
    }

    @Override
    public Vehiculo obtenerVehiculoPorVIN(String vin) {

        return vehiculos.stream()
                .filter(v ->
                    v.getVin().equalsIgnoreCase(vin)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public synchronized Vehiculo agregarVehiculo(Vehiculo vehiculo) {

        vehiculo.setId(siguienteId.getAndIncrement());

        vehiculos.add(vehiculo);

        return vehiculo;
    }
}