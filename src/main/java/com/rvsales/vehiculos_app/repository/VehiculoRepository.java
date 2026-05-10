package com.rvsales.vehiculos_app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rvsales.vehiculos_app.model.Vehiculo;
import java.util.List;





public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    
    Optional<Vehiculo> findByVin(String vin);
}
