package com.vehicles.desafiohexagon.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "VEHICLE_TYPE")
public class VehicleType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String desc;

//    @OneToMany
//    @JoinColumn(name = "vehicle_id")
//    private List<Vehicle> vehicle;
}
