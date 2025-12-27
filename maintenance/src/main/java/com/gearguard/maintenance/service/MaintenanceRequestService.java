package com.gearguard.maintenance.service;

import com.gearguard.maintenance.entity.*;
import com.gearguard.maintenance.repository.MaintenanceRequestRepository;
import com.gearguard.maintenance.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestService {

    @Autowired
    private MaintenanceRequestRepository requestRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    // Get all requests
    public List<MaintenanceRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    // Get by ID
    public MaintenanceRequest getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    // Create Request with auto-fill logic
    public MaintenanceRequest createRequest(MaintenanceRequest request) {
        if(request.getEquipmentId() != null) {
            equipmentRepository.findById(request.getEquipmentId()).ifPresent(eq -> {
                request.setTeamId(eq.getMaintenanceTeamId());
            });
        }
        request.setStatus(RequestStatus.NEW);
        request.setCreatedDate(LocalDateTime.now());
        return requestRepository.save(request);
    }

    // Update Request
    public MaintenanceRequest updateRequest(Long id, MaintenanceRequest request) {
        Optional<MaintenanceRequest> existingOpt = requestRepository.findById(id);
        if(existingOpt.isPresent()) {
            MaintenanceRequest existing = existingOpt.get();
            existing.setSubject(request.getSubject());
            existing.setDescription(request.getDescription());
            existing.setType(request.getType());
            existing.setEquipmentId(request.getEquipmentId());
            existing.setTeamId(request.getTeamId());
            existing.setAssignedMemberId(request.getAssignedMemberId());
            existing.setScheduledDate(request.getScheduledDate());
            existing.setStartDate(request.getStartDate());
            existing.setEndDate(request.getEndDate());
            existing.setDurationHours(request.getDurationHours());
            existing.setStatus(request.getStatus());
            // Overdue logic
            if(existing.getScheduledDate() != null && existing.getScheduledDate().isBefore(LocalDate.now()) &&
                    existing.getStatus() != RequestStatus.REPAIRED) {
                existing.setIsOverdue(true);
            } else {
                existing.setIsOverdue(false);
            }
            // Scrap logic
            if(existing.getStatus() == RequestStatus.SCRAP) {
                equipmentRepository.findById(existing.getEquipmentId()).ifPresent(eq -> {
                    eq.setIsScrapped(true);
                    equipmentRepository.save(eq);
                });
            }
            return requestRepository.save(existing);
        }
        return null;
    }

    // Delete Request
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

    // Get by Equipment
    public List<MaintenanceRequest> getByEquipmentId(Long equipmentId) {
        return requestRepository.findByEquipmentId(equipmentId);
    }

    // Get by Status
    public List<MaintenanceRequest> getByStatus(RequestStatus status) {
        return requestRepository.findByStatus(status);
    }
}
