package com.gearguard.maintenance.controller;

import com.gearguard.maintenance.entity.TeamMember;
import com.gearguard.maintenance.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamMemberController {

    @Autowired
    private TeamMemberService memberService;

    @GetMapping
    public List<TeamMember> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public TeamMember getMember(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public TeamMember createMember(@RequestBody TeamMember member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public TeamMember updateMember(@PathVariable Long id, @RequestBody TeamMember member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping("/team/{teamId}")
    public List<TeamMember> getMembersByTeam(@PathVariable Long teamId) {
        return memberService.getMembersByTeamId(teamId);
    }
}
