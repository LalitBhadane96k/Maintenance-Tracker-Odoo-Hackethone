package com.gearguard.maintenance.repository;

import com.gearguard.maintenance.entity.MaintenanceTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceTeamRepository extends JpaRepository<MaintenanceTeam, Long> {
}
