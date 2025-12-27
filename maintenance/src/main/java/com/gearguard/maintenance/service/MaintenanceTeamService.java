package com.gearguard.maintenance.service;

import com.gearguard.maintenance.entity.MaintenanceTeam;
import com.gearguard.maintenance.repository.MaintenanceTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceTeamService {

    @Autowired
    private MaintenanceTeamRepository teamRepository;

    public List<MaintenanceTeam> getAllTeams() {
        return teamRepository.findAll();
    }

    public MaintenanceTeam getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public MaintenanceTeam saveTeam(MaintenanceTeam team) {
        return teamRepository.save(team);
    }

    public MaintenanceTeam updateTeam(Long id, MaintenanceTeam team) {
        MaintenanceTeam existing = getTeamById(id);
        if(existing != null) {
            existing.setTeamName(team.getTeamName());
            return teamRepository.save(existing);
        }
        return null;
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
