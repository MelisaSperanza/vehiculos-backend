package com.rvsales.vehiculos_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;
    private String licensePlate;
    private String reservationStatus;
    private String indieVehicleModel;
    private String chassisModel;
    private String transmission;
    private String currentLocation;
    private String currentCountry;
    private String registrationCountry;
    private int modelYear;
    private double kms;
    private String currency;
    private double eurLocalRate;
    private double livePriceEurInclVat;
    private String thumbnailUrl;
    private String image;
}


