package com.vehicles.desafiohexagon.service;

import com.vehicles.desafiohexagon.exception.VehicleException;
import com.vehicles.desafiohexagon.model.Vehicle;
import com.vehicles.desafiohexagon.model.VehicleType;
import com.vehicles.desafiohexagon.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {

    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public VehicleType save(VehicleType vehicleType) {
        VehicleType vehicleTypeSave = vehicleTypeRepository.save(vehicleType);
        return vehicleTypeSave;
    }

    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType findById(Long id) {
        return vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new VehicleException("Tipo de veículo não encontrado para o id: " + id));
    }

    public VehicleType update(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public void delete(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}
