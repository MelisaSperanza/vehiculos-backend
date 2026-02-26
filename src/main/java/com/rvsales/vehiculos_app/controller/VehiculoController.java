package com.rvsales.vehiculos_app.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import com.rvsales.vehiculos_app.model.Vehiculo;
import com.rvsales.vehiculos_app.service.GoogleSheetsService;

//import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehiculos")
//@RequiredArgsConstructor
public class VehiculoController {

    private final GoogleSheetsService sheetsService;

    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    // Si quieres añadir datos de prueba al arrancar:
    /*@PostConstruct
    public void init() {
        listaVehiculos.add(new Vehiculo(1L, "Toyota", "Corolla", 2020, "Blanco", 15000));
        listaVehiculos.add(new Vehiculo(2L, "Ford", "Focus", 2019, "Negro", 13000));
        listaVehiculos.add(new Vehiculo(3L, "Seat", "Ibiza", 2021, "Rojo", 14500));
    }*/

    @GetMapping
    public List<List<Object>> obtenerVehiculos() throws Exception {
        return sheetsService.leerVehiculos();
    }
    //endpoint de prueba creado 26/02
        @GetMapping("/test")
    public String testEndpoint() {
        return "API funcionando";
    }
    @PostMapping
    public Vehiculo agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculo.setLicensePlate(String.valueOf (listaVehiculos.size() + 1));
        listaVehiculos.add(vehiculo);
        return vehiculo;
    }

    public VehiculoController(GoogleSheetsService sheetsService) {
    this.sheetsService = sheetsService;
}

}

