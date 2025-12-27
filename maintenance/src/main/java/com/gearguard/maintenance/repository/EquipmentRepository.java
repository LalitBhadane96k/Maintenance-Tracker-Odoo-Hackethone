package com.gearguard.maintenance.repository;

import com.gearguard.maintenance.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    // Custom query: find equipment by department
    List<Equipment> findByDepartment(String department);

    // Find equipment assigned to employee
    List<Equipment> findByEmployeeAssigned(String employeeAssigned);
}
