package com.gearguard.maintenance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    // Optional: link members (one-to-many)
    @OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL)
    private List<TeamMember> members;
}
