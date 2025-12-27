package com.gearguard.maintenance.service;

import com.gearguard.maintenance.entity.TeamMember;
import com.gearguard.maintenance.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository memberRepository;

    public List<TeamMember> getAllMembers() {
        return memberRepository.findAll();
    }

    public TeamMember getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public TeamMember saveMember(TeamMember member) {
        return memberRepository.save(member);
    }

    public TeamMember updateMember(Long id, TeamMember member) {
        TeamMember existing = getMemberById(id);
        if(existing != null) {
            existing.setUserName(member.getUserName());
            existing.setTeamId(member.getTeamId());
            return memberRepository.save(existing);
        }
        return null;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<TeamMember> getMembersByTeamId(Long teamId) {
        return memberRepository.findByTeamId(teamId);
    }
}
