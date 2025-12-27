package com.gearguard.maintenance.controller;

import com.gearguard.maintenance.entity.MaintenanceRequest;
import com.gearguard.maintenance.entity.RequestStatus;
import com.gearguard.maintenance.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:3000")
public class MaintenanceRequestController {

    @Autowired
    private MaintenanceRequestService requestService;

    @GetMapping
    public List<MaintenanceRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public MaintenanceRequest getRequest(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PostMapping
    public MaintenanceRequest createRequest(@RequestBody MaintenanceRequest request) {
        return requestService.createRequest(request);
    }

    @PutMapping("/{id}")
    public MaintenanceRequest updateRequest(@PathVariable Long id, @RequestBody MaintenanceRequest request) {
        return requestService.updateRequest(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
    }

    @GetMapping("/equipment/{equipmentId}")
    public List<MaintenanceRequest> getByEquipment(@PathVariable Long equipmentId) {
        return requestService.getByEquipmentId(equipmentId);
    }

    @GetMapping("/status/{status}")
    public List<MaintenanceRequest> getByStatus(@PathVariable RequestStatus status) {
        return requestService.getByStatus(status);
    }
}
