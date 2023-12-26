package com.example.springboot.controller;

import com.example.springboot.data.entity.Member;
import com.example.springboot.service.impl.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberRestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberServiceImpl msi;
    @GetMapping("/")                // 회원 목록
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = (List<Member>) msi.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }
    @GetMapping("new")              // 회원 등록 폼
    public void getNewMember(){
    }
    @PostMapping("new")             // 회원 등록
    public ResponseEntity<Member> postNewMember(@RequestBody Member member){
        Member savedMember = msi.saveMember(member);
        return ResponseEntity.status(HttpStatus.OK).body(savedMember);
    }
    @GetMapping("{id}")             // 회원 조회
    public ResponseEntity<Member> getOneMember(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(msi.getMemberById(id));
    }
    @GetMapping("{id}/edit")        // 회원 수정 폼
    public ResponseEntity<Member> getEditMember(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(msi.getMemberById(id));
    }
//    @PostMapping("{id}/edit")       // 회원 수정
//    public ResponseEntity<Member> postEditMember(@PathVariable Long id, @RequestBody Member member){
//        Member newMember = msi.replaceEditMember();
//        return ResponseEntity.status(HttpStatus.OK).body(newMember);
//    }
    @DeleteMapping("{id}/delete")   // 회원 삭제
    public void deleteMember(@PathVariable Long id) {
        msi.deleteById(id);
    }
};
