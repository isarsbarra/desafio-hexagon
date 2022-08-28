package com.vehicles.desafiohexagon.service;

import com.vehicles.desafiohexagon.exception.VehicleException;
import com.vehicles.desafiohexagon.model.Vehicle;
import com.vehicles.desafiohexagon.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        Vehicle vehicleSave = vehicleRepository.save(vehicle);
        return vehicleSave;
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleException("Veículo não encontrado para o id: " + id));
    }

    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }
}
