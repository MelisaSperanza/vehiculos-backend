package com.rvsales.vehiculos_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*public class Vehiculo {
    private Long id;
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private double precio;
}*/
    public class Vehiculo {
        private String VIN;
        private String LicensePlate;
        private String ReservationStatus;
        private String IndieVehicleModel;
        private String ChassisModel;
        private String Transmission;
        private String CurrentLocation;
        private String CurrentCountry;
        private String RegistrationCountry;
        private int ModelYear;
        private double KMs;
        private String Currency;
        private double EurLocalRate;
        private double LivePriceEurInclVat;
}

