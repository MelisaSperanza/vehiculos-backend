package com.rvsales.vehiculos_app;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.rvsales.vehiculos_app.model.Vehiculo;
import com.rvsales.vehiculos_app.service.VehiculoService;

@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://super-pasca-612521.netlify.app"
})
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> obtenerVehiculos(
            @RequestParam(required = false) String pais,
            @RequestParam(required = false) Double precioMax,
            @RequestParam(required = false) Integer anoMin) {

        return vehiculoService.filtrarVehiculos(
            pais,
            precioMax,
            anoMin
        );
    }

    @GetMapping("/{vin}")
    public Vehiculo obtenerVehiculoPorVin(
            @PathVariable String vin) {

        Vehiculo vehiculo =
            vehiculoService.obtenerVehiculoPorVIN(vin);

        if (vehiculo == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Vehículo no encontrado"
            );
        }

        return vehiculo;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "API funcionando";
    }

    @GetMapping("/debug")
    public String debug() {
        return "DEPLOY_OK_" + System.currentTimeMillis();
    }

    @PostMapping
    public Vehiculo agregarVehiculo(
            @RequestBody Vehiculo vehiculo) {

        return vehiculoService.agregarVehiculo(vehiculo);
    }
}