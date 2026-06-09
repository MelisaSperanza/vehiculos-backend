package com.rvsales.vehiculos_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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

    
    // Lista interna para pruebas
    private List<Vehiculo> listaVehiculos = new ArrayList<>();



   @GetMapping
    public List<Vehiculo> obtenerVehiculos(
        @RequestParam(required = false) String pais,
        @RequestParam(required = false) Double precioMax,
        @RequestParam(required = false) Integer anoMin) {

    return vehiculoService.filtrarVehiculos(pais, precioMax, anoMin);
    }

  @GetMapping("/{vin}")
    
    public Vehiculo obtenerVehiculoPorVin(@PathVariable String vin) {
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorVIN(vin);
        if (vehiculo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado");
        }
        return vehiculo;
    }
    

    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    // Endpoint de prueba
    @GetMapping("/test")
    public String testEndpoint() {
        return "API funcionando";
    }

    //otro endpoint de prueba:
    @GetMapping("/debug")
public String debug() {
    return "DEPLOY_OK_" + System.currentTimeMillis();
}    

    // Endpoint para agregar vehículos
    @PostMapping
    public Vehiculo agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculo.setLicensePlate(String.valueOf(listaVehiculos.size() + 1));
        listaVehiculos.add(vehiculo);
        return vehiculo;
    }


}