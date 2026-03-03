package com.rvsales.vehiculos_app.service;
import org.springframework.stereotype.Service;

import com.rvsales.vehiculos_app.model.Vehiculo;

import java.util.List;
import java.util.ArrayList;

@Service
public class MockGoogleSheetsVehiculoService implements VehiculoService {

    public List<Vehiculo> filtrarVehiculos(String pais, Double precioMax, Integer anoMin) {

    return obtenerVehiculos().stream()

        .filter(v -> pais == null || v.getCurrentCountry().equalsIgnoreCase(pais))
        .filter(v -> precioMax == null || v.getLivePriceEurInclVat() <= precioMax)
        .filter(v -> anoMin == null || v.getModelYear() >= anoMin)

        .toList();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
    List<Vehiculo> lista = new ArrayList<>();

lista.add(new Vehiculo("1HGCM82633A004352", "1234ABC", "Available", "Civic LX", "Chassis A", "Manual", "Barcelona", "Spain", "Spain", 2020, 15000.0, "EUR", 1.0, 18000.0));
lista.add(new Vehiculo("1FAFP404X1F192345", "5678DEF", "Reserved", "Focus SE", "Chassis B", "Automatic", "Madrid", "Spain", "Spain", 2018, 22000.0, "EUR", 1.0, 12000.0));
lista.add(new Vehiculo("5YJ3E1EA7KF317452", "9999TES", "Available", "Model 3", "Chassis C", "Automatic", "Valencia", "Spain", "Spain", 2022, 8000.0, "EUR", 1.0, 35000.0));
lista.add(new Vehiculo("WDBUF56X38B123456", "1122GHI", "Available", "E-Class", "Chassis D", "Automatic", "Seville", "Spain", "Spain", 2019, 30000.0, "EUR", 1.0, 28000.0));
lista.add(new Vehiculo("JHMFA16586S012345", "3344JKL", "Maintenance", "Fit LX", "Chassis E", "Manual", "Bilbao", "Spain", "Spain", 2017, 45000.0, "EUR", 1.0, 9500.0));
lista.add(new Vehiculo("3VW2K7AJ5FM012345", "5566MNO", "Available", "Golf Trendline", "Chassis F", "Manual", "Barcelona", "Spain", "Spain", 2016, 50000.0, "EUR", 1.0, 11000.0));
lista.add(new Vehiculo("2T1BURHE5JC012345", "7788PQR", "Reserved", "Corolla XLE", "Chassis G", "Automatic", "Madrid", "Spain", "Spain", 2018, 25000.0, "EUR", 1.0, 16000.0));
lista.add(new Vehiculo("SALWR2FK7FA123456", "9900STU", "Available", "Range Rover", "Chassis H", "Automatic", "Barcelona", "Spain", "Spain", 2021, 12000.0, "EUR", 1.0, 55000.0));
lista.add(new Vehiculo("1N4AL3AP1HC123456", "2233VWX", "Available", "Altima SV", "Chassis I", "Automatic", "Paris", "France", "France", 2019, 20000.0, "EUR", 1.0, 18000.0));
lista.add(new Vehiculo("KM8J3CA48JU123456", "4455YZA", "Maintenance", "Tucson GLS", "Chassis J", "Manual", "Seville", "Spain", "Spain", 2017, 35000.0, "EUR", 1.0, 14000.0));
lista.add(new Vehiculo("1C4RJFBG0JC123456", "6677BCD", "Available", "Grand Cherokee", "Chassis K", "Automatic", "Bilbao", "Spain", "Spain", 2020, 15000.0, "EUR", 1.0, 37000.0));
lista.add(new Vehiculo("JF1GPAL69DH123456", "8899EFG", "Reserved", "Impreza Sport", "Chassis L", "Manual", "Barcelona", "Spain", "Spain", 2018, 28000.0, "EUR", 1.0, 14500.0));
lista.add(new Vehiculo("WBA8E9G50GNU12345", "1010HIJ", "Available", "328i", "Chassis M", "Automatic", "Madrid", "Spain", "Spain", 2021, 10000.0, "EUR", 1.0, 29000.0));
lista.add(new Vehiculo("3FA6P0H73JR123456", "1212KLM", "Available", "Fusion SE", "Chassis N", "Automatic", "Valencia", "Spain", "Spain", 2019, 22000.0, "EUR", 1.0, 16000.0));
lista.add(new Vehiculo("SALGS2EF6HA123456", "1313NOP", "Maintenance", "Range Rover Sport", "Chassis O", "Automatic", "Seville", "Spain", "Spain", 2022, 5000.0, "EUR", 1.0, 68000.0));


return lista;
    }


}