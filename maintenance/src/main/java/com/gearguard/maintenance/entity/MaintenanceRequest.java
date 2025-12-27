package com.gearguard.maintenance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RequestType type; // CORRECTIVE or PREVENTIVE

    private String subject;
    private String description;

    private Long equipmentId;       // Linked Equipment
    private Long teamId;            // Auto filled from Equipment
    private Long assignedMemberId;  // Technician

    private LocalDate scheduledDate;  // For Preventive
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Double durationHours;  // Hours spent
    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.NEW;

    private Boolean isOverdue = false;
}
