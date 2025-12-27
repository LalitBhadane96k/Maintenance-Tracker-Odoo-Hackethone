package com.gearguard.maintenance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serialNumber;

    private LocalDate purchaseDate;
    private LocalDate warrantyEndDate;

    private String department;
    private String employeeAssigned;
    private String location;

    private Boolean isScrapped = false;

    // ManyToOne relation to MaintenanceTeam (we will create team later)
    private Long maintenanceTeamId;
}
