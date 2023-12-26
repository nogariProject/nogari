package com.example.springboot.service.impl;

import com.example.springboot.data.entity.Member;
import com.example.springboot.data.repository.MemberRepository;
import com.example.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository mr;

    public List<Member> getAllMembers() {
        return (List<Member>) mr.findAll();
    }
    public Member getMemberById(Long id){
        Optional<Member> member = mr.findById(id);
        return member.orElse(null);
    }
    public Member saveMember(Member member){
        return mr.save(member);
    }
    public void deleteById(Long id){
        mr.deleteById(id);
    }

    public Member replaceEditMember(Long id) {
        mr.deleteById(id);
        return null;
    }
}

