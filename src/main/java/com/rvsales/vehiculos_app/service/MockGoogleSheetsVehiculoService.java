package com.rvsales.vehiculos_app.service;

import org.springframework.stereotype.Service;
import com.rvsales.vehiculos_app.model.Vehiculo;

import java.util.List;
import java.util.ArrayList;

@Service
public class MockGoogleSheetsVehiculoService implements VehiculoService {

    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    // Constructor para poblar la lista
    public MockGoogleSheetsVehiculoService() {

        Vehiculo v1 = new Vehiculo();
        v1.setVin("1HGCM82633A004352");
        v1.setLicensePlate("1234ABC");
        v1.setReservationStatus("Available");
        v1.setIndieVehicleModel("Civic LX");
        v1.setChassisModel("Chassis A");
        v1.setTransmission("Manual");
        v1.setCurrentLocation("Barcelona");
        v1.setCurrentCountry("Spain");
        v1.setRegistrationCountry("Spain");
        v1.setModelYear(2020);
        v1.setKms(15000.0);
        v1.setCurrency("EUR");
        v1.setEurLocalRate(1.0);
        v1.setLivePriceEurInclVat(18000.0);
        v1.setThumbnailUrl("https://via.placeholder.com/150");

        listaVehiculos.add(v1);

        Vehiculo v2 = new Vehiculo();
        v2.setVin("1FAFP404X1F192345");
        v2.setLicensePlate("5678DEF");
        v2.setReservationStatus("Reserved");
        v2.setIndieVehicleModel("Focus SE");
        v2.setChassisModel("Chassis B");
        v2.setTransmission("Automatic");
        v2.setCurrentLocation("Madrid");
        v2.setCurrentCountry("Spain");
        v2.setRegistrationCountry("Spain");
        v2.setModelYear(2018);
        v2.setKms(22000.0);
        v2.setCurrency("EUR");
        v2.setEurLocalRate(1.0);
        v2.setLivePriceEurInclVat(12000.0);
        v2.setThumbnailUrl("https://via.placeholder.com/150");

        listaVehiculos.add(v2);

        Vehiculo v3 = new Vehiculo();
        v3.setVin("5YJ3E1EA7KF317452");
        v3.setLicensePlate("9999TES");
        v3.setReservationStatus("Available");
        v3.setIndieVehicleModel("Model 3");
        v3.setChassisModel("Chassis C");
        v3.setTransmission("Automatic");
        v3.setCurrentLocation("Valencia");
        v3.setCurrentCountry("Spain");
        v3.setRegistrationCountry("Spain");
        v3.setModelYear(2022);
        v3.setKms(8000.0);
        v3.setCurrency("EUR");
        v3.setEurLocalRate(1.0);
        v3.setLivePriceEurInclVat(35000.0);
        v3.setThumbnailUrl("https://via.placeholder.com/150");

        listaVehiculos.add(v3);

        Vehiculo v4 = new Vehiculo();
        v4.setVin("WDBUF56X38B123456");
        v4.setLicensePlate("1122GHI");
        v4.setReservationStatus("Available");
        v4.setIndieVehicleModel("E-Class");
        v4.setChassisModel("Chassis D");
        v4.setTransmission("Automatic");
        v4.setCurrentLocation("Seville");
        v4.setCurrentCountry("Spain");
        v4.setRegistrationCountry("Spain");
        v4.setModelYear(2019);
        v4.setKms(30000.0);
        v4.setCurrency("EUR");
        v4.setEurLocalRate(1.0);
        v4.setLivePriceEurInclVat(28000.0);
        v4.setThumbnailUrl("https://via.placeholder.com/150");

        listaVehiculos.add(v4);
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return listaVehiculos;
    }

    @Override
    public List<Vehiculo> filtrarVehiculos(String pais, Double precioMax, Integer anoMin) {
        return listaVehiculos.stream()
            .filter(v -> pais == null || v.getCurrentCountry().equalsIgnoreCase(pais))
            .filter(v -> precioMax == null || v.getLivePriceEurInclVat() <= precioMax)
            .filter(v -> anoMin == null || v.getModelYear() >= anoMin)
            .toList();
    }

    @Override
    public Vehiculo obtenerVehiculoPorVIN(String vin) {
        return listaVehiculos.stream()
            .filter(v -> v.getVin().equalsIgnoreCase(vin))
            .findFirst()
            .orElse(null);
    }
}