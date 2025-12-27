package com.gearguard.maintenance.controller;

import com.gearguard.maintenance.entity.MaintenanceTeam;
import com.gearguard.maintenance.service.MaintenanceTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "http://localhost:3000")
public class MaintenanceTeamController {

    @Autowired
    private MaintenanceTeamService teamService;

    @GetMapping
    public List<MaintenanceTeam> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public MaintenanceTeam getTeam(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public MaintenanceTeam createTeam(@RequestBody MaintenanceTeam team) {
        return teamService.saveTeam(team);
    }

    @PutMapping("/{id}")
    public MaintenanceTeam updateTeam(@PathVariable Long id, @RequestBody MaintenanceTeam team) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}
