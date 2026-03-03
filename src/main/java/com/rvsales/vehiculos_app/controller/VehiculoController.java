package com.rvsales.vehiculos_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.rvsales.vehiculos_app.model.Vehiculo;
import com.rvsales.vehiculos_app.service.VehiculoService;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // Lista interna para pruebas
    private List<Vehiculo> listaVehiculos = new ArrayList<>();



   @GetMapping
    public List<Vehiculo> obtenerVehiculos(
        @RequestParam(required = false) String pais,
        @RequestParam(required = false) Double precioMax,
        @RequestParam(required = false) Integer anoMin) {

    return vehiculoService.filtrarVehiculos(pais, precioMax, anoMin);
}
    

    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    // Endpoint de prueba
    @GetMapping("/test")
    public String testEndpoint() {
        return "API funcionando";
    }

    // Endpoint para agregar vehículos
    @PostMapping
    public Vehiculo agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculo.setLicensePlate(String.valueOf(listaVehiculos.size() + 1));
        listaVehiculos.add(vehiculo);
        return vehiculo;
    }

    // Opcional: inicializar algunos vehículos al arrancar (descomentar si quieres)
    /*
    @PostConstruct
    public void init() {
        listaVehiculos.add(new Vehiculo(1L, "Toyota", "Corolla", 2020, "Blanco", 15000));
        listaVehiculos.add(new Vehiculo(2L, "Ford", "Focus", 2019, "Negro", 13000));
        listaVehiculos.add(new Vehiculo(3L, "Seat", "Ibiza", 2021, "Rojo", 14500));
    }
    */
}