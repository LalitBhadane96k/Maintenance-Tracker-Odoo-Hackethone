package com.gearguard.maintenance.repository;

import com.gearguard.maintenance.entity.MaintenanceRequest;
import com.gearguard.maintenance.entity.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
    List<MaintenanceRequest> findByEquipmentId(Long equipmentId);
    List<MaintenanceRequest> findByStatus(RequestStatus status);
}
