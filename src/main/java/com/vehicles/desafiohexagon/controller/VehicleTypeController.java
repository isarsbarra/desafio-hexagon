package com.vehicles.desafiohexagon.controller;

import com.vehicles.desafiohexagon.exception.VehicleException;
import com.vehicles.desafiohexagon.exception.VehicleTypeException;
import com.vehicles.desafiohexagon.model.Vehicle;
import com.vehicles.desafiohexagon.model.VehicleType;
import com.vehicles.desafiohexagon.service.VehicleService;
import com.vehicles.desafiohexagon.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicle-type")
public class VehicleTypeController {

    private VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleType>> findAll(){
        try {
            List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
            return ResponseEntity.ok(vehicleTypes);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleType> findById(@PathVariable("id") Long id){
        try {
            VehicleType vehicleType = vehicleTypeService.findById(id);
            return ResponseEntity.ok(vehicleType);

        } catch (VehicleTypeException e) {
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<VehicleType> save(@RequestBody VehicleType vehicleType) {
        try {
            VehicleType vehicleTypeSave = vehicleTypeService.save(vehicleType);

            UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .scheme("http").host("localhost:8080")
                    .path("/hexagon").path("/vehicle-type/" + vehicleType.getId()).build();

            return ResponseEntity.created(new URI(uriComponents.toUriString())).build();

        } catch (VehicleTypeException e) {
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<VehicleType> update(@RequestBody VehicleType vehicleType){
        try {
            VehicleType vehicleTypeUpdate = vehicleTypeService.update(vehicleType);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            vehicleTypeService.delete(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
