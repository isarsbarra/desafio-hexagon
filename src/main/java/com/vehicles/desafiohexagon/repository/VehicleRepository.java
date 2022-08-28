package com.vehicles.desafiohexagon.repository;

import com.vehicles.desafiohexagon.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
