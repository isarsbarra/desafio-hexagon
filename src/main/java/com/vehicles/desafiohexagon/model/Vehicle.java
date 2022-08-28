package com.vehicles.desafiohexagon.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String desc;

//    @ManyToOne
//    @JoinColumn(name="vehicleType_id", nullable = false)
//    private VehicleType vehicleType;
    private int vehicleType;

    private String plate;

}
