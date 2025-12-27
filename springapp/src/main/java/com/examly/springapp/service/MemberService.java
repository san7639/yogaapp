package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.examly.springapp.model.Member;

public interface MemberService {
    List<Member> getAllMembers(Pageable pageable);
    Member createMember(Member member);
    Member getMemberById(Long id);
    Member updateMember(Long id, Member member);
}
