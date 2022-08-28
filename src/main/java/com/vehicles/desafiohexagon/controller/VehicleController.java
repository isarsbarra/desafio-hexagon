package com.vehicles.desafiohexagon.controller;

import com.vehicles.desafiohexagon.exception.VehicleException;
import com.vehicles.desafiohexagon.model.Vehicle;
import com.vehicles.desafiohexagon.model.VehicleType;
import com.vehicles.desafiohexagon.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAll(){
        try {
            List<Vehicle> vehicles = vehicleService.findAll();
            return ResponseEntity.ok(vehicles);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable("id") Long id){
        try {
            Vehicle vehicle = vehicleService.findById(id);
            return ResponseEntity.ok(vehicle);

        } catch (VehicleException e) {
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        try {
            Vehicle vehicleSave = vehicleService.save(vehicle);

            UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .scheme("http").host("localhost:8080")
                    .path("/hexagon").path("/vehicle/" + vehicle.getId()).build();

            return ResponseEntity.created(new URI(uriComponents.toUriString())).build();

        } catch (VehicleException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle){
        try {
            Vehicle vehicleUpdate = vehicleService.update(vehicle);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            vehicleService.delete(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
