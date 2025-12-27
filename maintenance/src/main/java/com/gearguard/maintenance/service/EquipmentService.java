package com.gearguard.maintenance.service;

import com.gearguard.maintenance.entity.Equipment;
import com.gearguard.maintenance.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Long id, Equipment equipment) {
        Optional<Equipment> existing = equipmentRepository.findById(id);
        if(existing.isPresent()) {
            Equipment eq = existing.get();
            eq.setName(equipment.getName());
            eq.setSerialNumber(equipment.getSerialNumber());
            eq.setPurchaseDate(equipment.getPurchaseDate());
            eq.setWarrantyEndDate(equipment.getWarrantyEndDate());
            eq.setDepartment(equipment.getDepartment());
            eq.setEmployeeAssigned(equipment.getEmployeeAssigned());
            eq.setLocation(equipment.getLocation());
            eq.setMaintenanceTeamId(equipment.getMaintenanceTeamId());
            eq.setIsScrapped(equipment.getIsScrapped());
            return equipmentRepository.save(eq);
        }
        return null;
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
